package com.jung.krab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jung.krab.core.network.Repository
import com.jung.krab.core.network.RetrofitBuilder
import com.jung.krab.dto.ApiResult
import com.jung.krab.ui.theme.KrabTheme
import com.jung.krab.utils.LogUtils
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val repository = Repository(RetrofitBuilder())
    val viewModelFactory = ViewModelFactory(repository)
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        lifecycleScope.launch {
            viewModel.getData().collectLatest { result ->
                if(result is ApiResult.Success){
                    LogUtils.debug(result.data.id)
                    LogUtils.debug(result.data.joke)
                    LogUtils.debug(result.data.status.toString())
                }else if(result is ApiResult.Exception){
                    result.e.message?.let { LogUtils.error(it) }
                }
            }
        }

        setContent {
            KrabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    LogUtils.debug("S")
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KrabTheme {
        Greeting("Android")
    }
}


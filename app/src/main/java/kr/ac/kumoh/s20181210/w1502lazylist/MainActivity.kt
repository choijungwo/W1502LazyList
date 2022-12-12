package kr.ac.kumoh.s20181210.w1502lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20181210.w1502lazylist.ui.theme.W1502LazyListTheme

data class Song(var title: String, var singer: String)
private val songs = mutableListOf<Song>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repeat(10) {
            songs.add(Song("가시", "버즈"))
            songs.add(Song("카레", "노라조"))
            songs.add(Song("첫눈처럼 너에게 가겠다", "에일리"))
        }

        setContent {
                MyApp(songs)
            }
        }
    }
}

@Composable
fun MyApp(){
    W1502LazyListTheme {
            SongList()
        }
}

@Composable
fun SongItem(song: Song) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(Color(255, 210, 210))
            .padding(8.dp),
    ) {
        Text(text = song.title, fontSize = 30.sp)
        Text(text = song.singer, fontSize = 20.sp)
    }
}

@Composable
fun SongList() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(4.dp),
    ) {
        items(songs)  { song ->
            SongItem(song)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
 /*   W1502LazyListTheme {
        MyApp()
    }*/
}
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.tiktok.R
import com.app.tiktok.ui.videoplayer.VideoPlayer
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

data class ContentItem(val id: Int, val videoUrl: String)

val contentItems = listOf(
    ContentItem(1, "https://videos.pexels.com/video-files/2795405/2795405-uhd_1440_2560_25fps.mp4"),
    ContentItem(2, "https://videos.pexels.com/video-files/4646327/4646327-uhd_1440_2732_25fps.mp4"),
    ContentItem(3, "https://videos.pexels.com/video-files/6507676/6507676-hd_1080_1920_25fps.mp4"),
)


@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TikTokScreen(navController: NavHostController) {
    val pagerState = rememberPagerState()
    val context = LocalContext.current

    Scaffold(content = {
        Box(modifier = Modifier.fillMaxSize()) {
            if (!LocalInspectionMode.current) {
                VerticalPager(
                    state = pagerState,
                    count = contentItems.size,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    // Reinitialize the video player with the new video URL on each swipe
                    val videoUrl = contentItems[page].videoUrl
                    VideoPlayer(
                        context = context,
                        videoUrl = videoUrl,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            } else {
                // Render a simple view for preview
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Preview Mode", modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Home, // Replace with correct icon
                        contentDescription = "Live", tint = Color.White
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Siguiendo", color = Color.Gray, fontSize = 16.sp, modifier = Modifier.weight(2f), textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Para ti", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(2f), textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White
                        )
                    }
                }
            }

            // Right Side Buttons
            Column(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp)
                    .offset(y = (-100).dp), // Agrega margen inferior simulando un offset negativo
                horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Favorite, // Replace with correct icon
                        contentDescription = "Like", tint = Color.White
                    )
                }
                Text(
                    text = "10.1 mil", color = Color.White, fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Home, // Replace with correct icon
                        contentDescription = "Comment", tint = Color.White
                    )
                }
                Text(
                    text = "2297", color = Color.White, fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Home, // Replace with correct icon
                        contentDescription = "Bookmark", tint = Color.White
                    )
                }
                Text(
                    text = "974", color = Color.White, fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Share, // Replace with correct icon
                        contentDescription = "Share", tint = Color.White
                    )
                }
                Text(
                    text = "787", color = Color.White, fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.tik_tok), // Replace with profile image
                    contentDescription = "Profile", modifier = Modifier
                        .size(48.dp)
                        .padding(4.dp)
                        .border(2.dp, Color.White, CircleShape)
                )
            }

            // Bottom Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(color = Color.Black), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Home, // Replace with correct icon
                        contentDescription = "Home", tint = Color.White
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Home, // Replace with correct icon
                        contentDescription = "Friends", tint = Color.White
                    )
                }
                IconButton(
                    onClick = {}, modifier = Modifier.size(70.dp) // Ajusta el tamaño del IconButton
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plus), // Reemplaza con tu recurso drawable
                        contentDescription = "Add", modifier = Modifier.size(70.dp) // Ajusta el tamaño según sea necesario
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Home, // Replace with correct icon
                        contentDescription = "Inbox", tint = Color.White
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Person, // Replace with correct icon
                        contentDescription = "Profile", tint = Color.White
                    )
                }
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun PreviewTikTokScreen() {
    TikTokScreen(navController = rememberNavController())
}

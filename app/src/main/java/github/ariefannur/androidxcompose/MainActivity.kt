package github.ariefannur.androidxcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.Composable
import androidx.ui.foundation.DrawImage
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import android.util.DisplayMetrics
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.core.gesture.PressGestureDetector
import androidx.ui.graphics.Color
import androidx.ui.text.TextStyle
import androidx.ui.text.font.Font
import androidx.ui.text.font.FontFamily
import github.ariefannur.androidxcompose.model.Menu


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           home()
        }
    }

    private val family = FontFamily(
        font = Font(name = "oswald_medium.ttf")
    )

    @Composable
    fun home() = MaterialTheme {


        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

            Column {

                Container(height = 250.dp, width = displayMetrics.widthPixels.dp) {
                    Wrap {

                        DrawImage(
                            image = imageFromResource(resources, R.drawable.bg_food)
                        )

                        Column(
                            mainAxisAlignment = MainAxisAlignment.End,
                            crossAxisAlignment = CrossAxisAlignment.End,
                            mainAxisSize = LayoutSize.Expand,
                            crossAxisSize = LayoutSize.Expand
                        ) {

                            Padding(left = 16.dp, bottom = 16.dp, right = 16.dp) {
                                Text(
                                    "Welcome to".toUpperCase(),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontFamily = family
                                    )
                                )
                            }

                            Padding(left = 16.dp, bottom = 10.dp, right = 16.dp) {
                                Text(
                                    "Resto App".toUpperCase(),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 30.sp,
                                        fontFamily = family
                                    )
                                )
                            }
                        }
                    }
                }

                Padding(top = 16.dp) {
                    Column {

                        val listGrid = listOf(
                            listOf(
                                Menu("Burger", R.drawable.ic_hamburger),
                                Menu("Bar", R.drawable.ic_beer),
                                Menu("Coffee", R.drawable.ic_coffee)
                            ),
                            listOf(
                                Menu("Vegetables", R.drawable.ic_vegetables),
                                Menu("Harvest", R.drawable.ic_harvest),
                                Menu("Tea", R.drawable.ic_coffee)
                            ),
                            listOf(
                                Menu("Fast Food", R.drawable.ic_fast_food),
                                Menu("Bar", R.drawable.ic_beer),
                                Menu("Harvest", R.drawable.ic_harvest)
                            )
                        )

                        generateMenuGrid(listGrid)
                    }
                }
            }
    }


    @Composable
    fun itemData(text: String) {
        Text (text = text)
    }

    @Composable
    fun generateMenuGrid(listGrid: List<List<Menu>>){


        listGrid.forEach {

            Row (mainAxisSize = LayoutSize.Expand,
                mainAxisAlignment = MainAxisAlignment.SpaceAround,
                crossAxisSize = LayoutSize.Wrap,
                crossAxisAlignment = CrossAxisAlignment.Center) {
                it.forEach {
                    val click = +state{false}
                    PressGestureDetector (onPress = {
                        click.value = true
                    }, onRelease = {
                        click.value = false

                    }) {
                        Container(padding = EdgeInsets(10.dp), height = 90.dp, width = 110.dp) {

                            Column(
                                mainAxisAlignment = MainAxisAlignment.Center,
                                crossAxisAlignment = CrossAxisAlignment.Center
                            ) {

                                Container(width = 30.dp, height = 30.dp) {
                                    DrawImage(
                                        image = imageFromResource(resources, it.menu)
                                    )
                                }

                                Text(text = it.title, style = TextStyle(color = when(click.value){
                                    true -> {
                                        Color.Green
                                    }
                                    else -> Color.Black
                                    }
                                ))
                            }
                        }
                    }
                }
            }
        }
    }

}

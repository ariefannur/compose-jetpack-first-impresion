# compose-jetpack-first-impresion
this is sample layout build with compose. declarative ui kotlin base

<img src="https://github.com/ariefannur/compose-jetpack-first-impresion/blob/master/app/src/main/res/drawable/jetpack_compose_sample.png" height="550ems" />

Here is sample layout to understanding jetpack compose. 
1. include layouting `Row(), Collumn(), and Wrap()`
2. sample image resource display
3. sample event handler 
4. sample grid layout

#### Sample Generate Grid Layout
```kotlin
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
```




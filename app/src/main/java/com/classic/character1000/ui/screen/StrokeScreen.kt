package com.classic.character1000.ui.screen

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.dp
import com.classic.character1000.dictionary.StrokeOrder

@Composable
fun StrokeScreen(
    strokeOrder: StrokeOrder
){
    var strokePaths by remember { mutableStateOf(listOf<Path>()) }
    val temppaths = mutableListOf<Path>()
    for (stroke in strokeOrder.strokes) {
        temppaths.add(PathParser().parsePathString(stroke).toPath())
    }
    strokePaths = temppaths

    var medianPaths by remember { mutableStateOf(listOf<Path>()) }

    val tempmedianpaths = mutableListOf<Path>()

    val strokeMedians = strokeOrder.medians

    var totalPathLength by remember { mutableStateOf(0f) }

    var animatedPath by remember { mutableStateOf(Path()) }

    val drawPathAnimation = remember {
        Animatable(0f)
    }

    for ((index,strokePoints) in strokeMedians.withIndex()) {
        val path = Path()
        for ((indexPoint,point) in strokePoints.withIndex()) {
            val x = point[0].toFloat()
            val y = point[1].toFloat()
            if (indexPoint == 0) {
                path.moveTo(x, y)
                //points.add(Point(x.toInt(), y.toInt())) // stroke start
            } else {
                path.lineTo(x, y)
            }
//            if (array3.length() - 1 == j) { // storke end
//                points.add(Point(x.toInt(), y.toInt()))
//            }
        }
        tempmedianpaths.add(path)
    }
    medianPaths = tempmedianpaths

    //Log.e("StrokeScreenMain",medianPaths.toString())

    if(medianPaths.isNotEmpty()){
        LaunchedEffect(key1 = Unit){
            Log.e("StrokeScreenMedian1",medianPaths.toString())

            totalPathLength = medianPaths.sumOf { path ->
                val tempPathMeasure = PathMeasure()
                tempPathMeasure.setPath(path,false)
                tempPathMeasure.length.toDouble()
            }.toFloat()

            drawPathAnimation.animateTo(
                1f,
                animationSpec = tween(totalPathLength.toInt() * 5)
            )
        }
    }


//    LaunchedEffect(
//        key1 = Unit
//    ) {
//        Log.e("StrokeScreenMedian2",medianPaths.toString())
//
//
//    }




//    totalPathLength = remember {
//        medianPaths.sumOf { path ->
//            val tempPathMeasure = PathMeasure()
//            tempPathMeasure.setPath(path,false)
//            tempPathMeasure.length.toDouble()
//        }.toFloat()
//    }





    LaunchedEffect(drawPathAnimation.value) {
        val newPath = Path()
        var currentLength = 0f

        for (path in medianPaths) {
            val pathMeasure = PathMeasure().apply { setPath(path, false) }
            val pathLength = pathMeasure.length

            if (currentLength + pathLength >= drawPathAnimation.value * totalPathLength) {
                val start = currentLength
                val end = drawPathAnimation.value * totalPathLength
                pathMeasure.getSegment(
                    start - currentLength,
                    end - currentLength,
                    newPath,
                    true
                )
                break
            } else {
                pathMeasure.getSegment(0f, pathLength, newPath, true)
                currentLength += pathLength
            }
        }

        animatedPath = newPath
    }





    //var animatedPath by remember { mutableStateOf(Path()) }

//    val animatedPath = remember {
//        derivedStateOf {
//            val newPath = Path()
//            var currentLength = 0f
//
//            for (path in medianPaths) {
//                val pathMeasure = PathMeasure()
//                pathMeasure.setPath(path, false)
//                val pathLength = pathMeasure.length
//
//                if (currentLength + pathLength >= drawPathAnimation.value * totalPathLength) {
//                    val start = currentLength
//                    val end = drawPathAnimation.value * totalPathLength
//                    pathMeasure.getSegment(
//                        start - currentLength,
//                        end - currentLength,
//                        newPath,
//                        true
//                    )
//                    break
//                } else {
//                    pathMeasure.getSegment(0f, pathLength, newPath, true)
//                    currentLength += pathLength
//                }
//            }
//
//            newPath
//        }
//    }




    Canvas(modifier = Modifier.fillMaxSize()) {
        withTransform({
            scale(scaleX = 1f, scaleY = -1f)
            translate(left = -55f, top = 30f)
            scale(scaleX = 0.9f, scaleY = 0.9f)
        }){
            strokePaths.forEach { path ->
                drawPath(
                    path = path,
                    color = Color.Black,
                    style = Stroke(width = 5.dp.toPx(), pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f)))
                )
            }

            //Log.e("StrokeScreenMedianLength",totalPathLength.toString())

            drawPath(
                path = animatedPath,
                color = Color.Black,
                style = Stroke(
                    width = 5.dp.toPx(),
                    //pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                )
            )



        }
    }
}

//https://juejin.cn/post/7103192601515425823
//https://github.com/zuo26/BlogSample/blob/master/app/src/main/java/com/blog/demo41/StrokeOrderView.kt
//https://stackoverflow.com/questions/75680892/how-to-animate-drawpath-on-jetpack-compose-canvas
//https://realsoc.medium.com/drawing-with-compose-the-animated-string-path-2dfa14af0739
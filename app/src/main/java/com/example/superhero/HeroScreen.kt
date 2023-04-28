package com.example.superhero

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroList
import com.example.superhero.model.HeroList.heroes
import com.example.superhero.ui.theme.SuperheroTheme




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HeroApp(

) {
    Scaffold(
        topBar = { TopBar() }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colors.background)

        ) {
            items(heroes) {
                HeroCard(hero = it) {
                    
                }
            }
        }
    }
}

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val surfaceColor = MaterialTheme.colors.surface
    val backgroundColor = if (isSystemInDarkTheme()) surfaceColor.copy(0.8f) else surfaceColor

    Card(
        modifier = modifier.padding(16.dp),
        elevation = 2.dp,
        backgroundColor = backgroundColor
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(surfaceColor)
                    .clickable(onClick = { expanded = !expanded })
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
            ) {
                HeroText(
                    name = hero.name,
                    description = hero.description,
                    hero = hero
                ) {}

                Spacer(modifier = Modifier.weight(1f))

                HeroImage(
                    hero = hero,
                    modifier = Modifier
                )
            }

            if (expanded) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                ) {
                    Row {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            HeroStats(hero = hero)
                        }
                        Column {
                            HeroStatsIcon(
                                hero = hero,
                                modifier = Modifier
                                    .padding(
                                        top = 16.dp,
                                        end = 16.dp
                                    )
                                    .size(20.dp)

                            )
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}


@Composable
fun HeroImage(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(hero.image),
        contentDescription = null,
        modifier = Modifier
            .padding(
                end = 16.dp,
                start = 16.dp,
                top = 16.dp,
                bottom = 16.dp
            )
            .clip(RoundedCornerShape(8.dp))
            .size(80.dp)

    )
}

@Composable
fun HeroText(
    @StringRes name: Int,
    @StringRes description: Int,
    hero: Hero,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(220.dp)
    ) {
        Text(
            text = stringResource(hero.name),
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                ),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(hero.description),
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
            style = MaterialTheme.typography.body1
        )
    }
}


@Composable
fun HeroStats(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Text(
            text = stringResource(hero.power),
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(hero.skills),
            style = MaterialTheme.typography.body1,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(hero.health),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun HeroStatsIcon(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Column(

    ) {
        Image(
            painter = painterResource(hero.icon1),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
            modifier = Modifier
                .padding(
                    top = 5.dp,
                    end = 5.dp,
                    bottom = 8.dp
                ),
        )
        Image(
            painter = painterResource(hero.icon2),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
            modifier = Modifier
                .padding(
                    end = 5.dp,
                    bottom = 8.dp
                )
        )
        Image(
            painter = painterResource(hero.icon3),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
            modifier = Modifier
                .padding(
                    end = 5.dp,
                    bottom = 5.dp
                )
        )
    }
}


@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroPreview() {
    SuperheroTheme {
        HeroApp()
    }
}
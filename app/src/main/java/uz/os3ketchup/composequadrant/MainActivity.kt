package uz.os3ketchup.composequadrant


import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.os3ketchup.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                     color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant() {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .weight(1F)
        ) {
            ComposableInfoCard(
                title = stringResource(id = R.string.text_compose),
                description = stringResource(
                    id = R.string.description_text_compose
                ),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1F)
            )
            ComposableInfoCard(
                title = stringResource(id = R.string.image_compose), description = stringResource(
                    id = R.string.description_image_compose
                ), backgroundColor = Color.Yellow,modifier = Modifier.weight(1F)
            )
        }
        Row(modifier = Modifier.weight(1F)) {
            ComposableInfoCard(
                title = stringResource(id = R.string.row_compose), description = stringResource(
                    id = R.string.description_row_compose
                ), backgroundColor = Color.Cyan,modifier = Modifier.weight(1F)
            )
            ComposableInfoCard(
                title = stringResource(id = R.string.column_compose), description = stringResource(
                    id = R.string.description_column_compose
                ), backgroundColor = Color.LightGray,modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String, description: String, backgroundColor: Color, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme() {
        Quadrant()
    }
}
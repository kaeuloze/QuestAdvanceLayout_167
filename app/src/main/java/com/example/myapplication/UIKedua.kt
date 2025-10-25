package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UIKedua(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto profil bundar
        val foto = painterResource(id = R.drawable.profil)
        Image(
            painter = foto,
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(25.dp))

        // Baris ikon sosial media
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val icons = listOf(
                R.drawable.ic_facebook,
                R.drawable.ic_google,
                R.drawable.ic_twitter,
                R.drawable.ic_linkedin
            )
            icons.forEach { icon ->
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
        }

        // Nama dan username
        Text(
            text = "Mariska Esa Purnomo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "@mariskaae_",
            fontSize = 15.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Saya seorang Mahasiswi Universitas Muhammadiyah Yogyakarta",
            fontSize = 15.sp,
            color = Color.Black,
            lineHeight = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(35.dp))

        val menuList = listOf(
            Pair("Privacy", R.drawable.ic_privacy),
            Pair("Riwayat Transaksi", R.drawable.ic_history),
            Pair("Pengaturan", R.drawable.ic_setting)
        )
        menuList.forEach { (title, icon) ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF2E2E2E),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clickable { /* aksi klik di sini */ }
                    .padding(horizontal = 20.dp, vertical = 18.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = icon),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = title,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_next), // Gambar panah
                            contentDescription = "Next", // Deskripsi panah
                            modifier = Modifier.size(22.dp), // Ukuran panah 22dp
                            colorFilter = ColorFilter.tint(Color.Gray) // Warna panah abu-abu
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(50.dp))

            // Footer
            Text(
                text = "© 2025 Mariska Esa Purnomo",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

        }
    }
}

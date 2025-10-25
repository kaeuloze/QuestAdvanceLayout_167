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

@Composable // Penanda bahwa fungsi ini adalah komponen UI di Jetpack Compose
fun UIKedua(modifier: Modifier = Modifier) { // Fungsi Composable bernama UIKedua, menerima parameter opsional Modifier
    Column( // Menyusun elemen UI secara vertikal
        modifier = Modifier
            .fillMaxSize() // Kolom memenuhi seluruh ukuran layar
            .padding(top = 60.dp, start = 24.dp, end = 24.dp), // Memberi jarak di bagian atas dan sisi kiri-kanan
        horizontalAlignment = Alignment.CenterHorizontally // Semua konten diatur ke tengah secara horizontal
    ) {
        // Foto profil bundar
        val foto = painterResource(id = R.drawable.profil) // Mengambil gambar profil dari folder drawable
        Image( // Menampilkan gambar profil
            painter = foto, // Gambar yang akan digunakan
            contentDescription = "Foto Profil", // Deskripsi gambar (untuk aksesibilitas)
            modifier = Modifier
                .size(160.dp) // Ukuran gambar 160dp
                .clip(CircleShape), // Membuat gambar menjadi berbentuk lingkaran
            contentScale = ContentScale.Crop // Memotong gambar agar sesuai dengan bentuk lingkaran
        )

        Spacer(modifier = Modifier.height(25.dp)) // Menambahkan jarak vertikal 25dp setelah foto

        // Baris ikon sosial media
        Row( // Menyusun ikon sosial media secara horizontal
            horizontalArrangement = Arrangement.spacedBy(12.dp), // Jarak antar ikon 12dp
            verticalAlignment = Alignment.CenterVertically // Ikon disejajarkan secara vertikal di tengah
        ) {
            val icons = listOf( // Daftar ikon sosial media yang akan ditampilkan
                R.drawable.ic_facebook,
                R.drawable.ic_google,
                R.drawable.ic_twitter,
                R.drawable.ic_linkedin
            )
            icons.forEach { icon -> // Melakukan perulangan untuk setiap ikon dalam daftar
                IconButton(onClick = { }) { // Tombol untuk masing-masing ikon (belum ada aksi klik)
                    Image( // Menampilkan gambar ikon
                        painter = painterResource(id = icon), // Memanggil ikon dari resource
                        contentDescription = null, // Tidak ada deskripsi tambahan
                        modifier = Modifier.size(36.dp) // Ukuran ikon 36dp
                    )
                }
            }
        }

        // Nama dan username
        Text(
            text = "Mariska Esa Purnomo", // Menampilkan nama pengguna
            fontSize = 24.sp, // Ukuran teks besar
            fontWeight = FontWeight.Bold, // Tebal huruf tebal
            color = Color.Black // Warna teks hitam
        )
        Text(
            text = "@mariskaae_", // Menampilkan username pengguna
            fontSize = 15.sp, // Ukuran teks lebih kecil
            color = Color.Black // Warna hitam
        )

        Spacer(modifier = Modifier.height(10.dp)) // Memberi jarak vertikal 10dp

        // Deskripsi singkat pengguna
        Text(
            text = "Saya seorang Mahasiswi Universitas Muhammadiyah Yogyakarta", // Isi deskripsi
            fontSize = 15.sp, // Ukuran teks normal
            color = Color.Black, // Warna teks hitam
            lineHeight = 20.sp, // Jarak antarbaris teks
            textAlign = TextAlign.Center, // Teks diratakan ke tengah
            modifier = Modifier.fillMaxWidth() // Mengisi lebar penuh kolom
        )

        Spacer(modifier = Modifier.height(35.dp)) // Jarak vertikal 35dp sebelum bagian menu

        // ---- Bagian menu (dulu UIKedua) ----
        val menuList = listOf( // Daftar menu yang akan ditampilkan
            Pair("Privacy", R.drawable.ic_privacy), // Menu 1: Privacy
            Pair("Riwayat Transaksi", R.drawable.ic_history), // Menu 2: Riwayat Transaksi
            Pair("Pengaturan", R.drawable.ic_setting) // Menu 3: Pengaturan
        )

        menuList.forEach { (title, icon) -> // Perulangan untuk setiap item menu
            Box( // Wadah latar belakang tiap menu
                modifier = Modifier
                    .fillMaxWidth() // Lebar penuh layar
                    .background( // Memberikan warna dan bentuk latar belakang
                        color = Color(0xFF2E2E2E), // Warna abu tua
                        shape = RoundedCornerShape(20.dp) // Sudut membulat 20dp
                    )
                    .clickable { /* aksi klik di sini */ } // Dapat diklik (belum diisi fungsi)
                    .padding(horizontal = 20.dp, vertical = 18.dp) // Memberi ruang dalam Box
            ) {
                Row( // Menyusun isi menu (ikon + teks + panah)
                    verticalAlignment = Alignment.CenterVertically, // Semua elemen sejajar vertikal
                    horizontalArrangement = Arrangement.SpaceBetween, // Ikon-teks di kiri, panah di kanan
                    modifier = Modifier.fillMaxWidth() // Mengisi lebar penuh
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) { // Bagian kiri: ikon + teks
                        Image(
                            painter = painterResource(id = icon), // Menampilkan ikon menu
                            contentDescription = null, // Tanpa deskripsi tambahan
                            modifier = Modifier.size(28.dp) // Ukuran ikon 28dp
                        )

                        Spacer(modifier = Modifier.width(16.dp)) // Jarak antara ikon dan teks

                        Text(
                            text = title, // Nama menu (misalnya: Privacy)
                            fontSize = 18.sp, // Ukuran teks sedang
                            color = Color.White, // Warna teks putih
                            fontWeight = FontWeight.Medium // Ketebalan sedang
                        )
                    }

                    // Panah kanan (indikator navigasi)
                    Image(
                        painter = painterResource(id = R.drawable.ic_next), // Gambar panah
                        contentDescription = "Next", // Deskripsi panah
                        modifier = Modifier.size(22.dp), // Ukuran panah 22dp
                        colorFilter = ColorFilter.tint(Color.Gray) // Warna panah abu-abu
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp)) // Jarak antar menu
        }

        Spacer(modifier = Modifier.height(50.dp)) // Jarak bawah sebelum footer

        // Footer (hak cipta)
        Text(
            text = "© 2025 Mariska Esa Purnomo", // Teks footer
            fontSize = 12.sp, // Ukuran teks kecil
            color = Color.Gray, // Warna teks abu-abu
            modifier = Modifier.align(Alignment.CenterHorizontally) // Ditempatkan di tengah
        )
    }
}


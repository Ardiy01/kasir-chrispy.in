drop table if exists produk, pegawai, transaksi, pembeli, detail_transaksi;

create table produk(
                       id_produk serial primary key ,
                       nama_produk varchar(15) not null ,
                       harga int not null ,
                       keterangan text
);

insert into produk(nama_produk, harga, keterangan)
values
    ('Ayama Sayap', 5000, 'Ayam bagian sayap'),
    ('Ayam Paha', 6000, 'Ayam bagain paha'),
    ('Ayam Dada', 6500, 'Ayam bagian dada'),
    ('Es Small', 5000, 'Es ukuran gelas small'),
    ('Es Medium', 8000, 'Es ukuran gelas medium'),
    ('Es Large', 10000, 'Es ukuran gelas large');

create table pegawai(
                        id_pegawai serial primary key ,
                        nama_pegawai varchar(50) not null
);

insert into pegawai(nama_pegawai)
values
    ('Ayani'),
    ('Azka'),
    ('Ardi');

create table pembeli(
                        id_pembeli serial primary key ,
                        nama_pembeli varchar(20) not null
);

insert into pembeli(nama_pembeli)
values
    ('ayanis rafaela'),
    ('rizki ardana'),
    ('Fiki Setiawan'),
    ('Varel Ananta'),
    ('Alister bryan ');

create table transaksi(
                          id_transaksi serial primary key ,
                          tanggal date not null ,
                          id_pegawai int null ,
                          id_pembeli int null ,
                          keterangan text
);
alter table transaksi add foreign key (id_pegawai) references pegawai(id_pegawai);
alter table transaksi add foreign key (id_pembeli) references pembeli(id_pembeli);

insert into transaksi (tanggal, id_pegawai, id_pembeli, keterangan)
values
    ('12 november 2021', 1, 1, 'Meja nomor 4'),
    ('13 november 2021', 2, 2, 'Meja nomor 5'),
    ('14 november 2021', 1, 3, 'Dibawa pulang');

create table detail_transaksi(
                                 id_transaksi int null,
                                 id_produk int null ,
                                 jumlah_produk int not null ,
                                 diskon float
);
alter table detail_transaksi add  foreign key (id_transaksi) references transaksi(id_transaksi);
alter table detail_transaksi add foreign key (id_produk) references produk(id_produk);

insert into detail_transaksi (id_transaksi, id_produk, jumlah_produk, diskon)
values
    (1, 1, 2, 0),
    (1, 2, 3, 0),
    (2, 3, 5, 10)

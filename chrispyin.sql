drop table if exists produk, pegawai, transaksi, pembeli, detail_transaksi;

create table produk(
                       id_produk varchar(4) primary key ,
                       nama_produk varchar(15) not null ,
                       harga int not null ,
                       keterangan text
);

create table pegawai(
                        id_pegawai serial primary key ,
                        nama_pegawai varchar(50) not null
);

create table pembeli(
                        id_pembeli serial primary key ,
                        nama_pembeli varchar(20) not null
);

create table transaksi(
                          id_transaksi serial primary key ,
                          jumlah_produk int not null ,
                          tanggal date not null ,
                          id_pegawai int not null ,
                          id_pembeli int not null ,
                          keterangan text
);

create table detail_transaksi(
                                 id_transaksi serial not null ,
                                 id_produk varchar(5) not null ,
                                 diskon float
);


alter table transaksi add foreign key (id_pegawai) references pegawai(id_pegawai);
alter table transaksi add foreign key (id_pembeli) references pembeli(id_pembeli);
alter table detail_transaksi add  foreign key (id_transaksi) references transaksi(id_transaksi);
alter table detail_transaksi add foreign key (id_produk) references produk(id_produk);


insert into produk(id_produk, nama_produk, harga, keterangan)
values
    ('AS1', 'Ayama Sayap', 5000, 'Ayam bagian sayap'),
    ('AP1', 'Ayam Paha', 6000, 'Ayam bagain paha'),
    ('AD1', 'Ayam Dada', 6500, 'Ayam bagian dada'),
    ('ES1', 'Es Small', 5000, 'Es ukuran gelas small'),
    ('EM1', 'Es Medium', 8000, 'Es ukuran gelas medium'),
    ('EL1', 'Es Large', 10000, 'Es ukuran gelas large');

insert into pegawai(nama_pegawai)
values
    ('Ayani'),
    ('Azka'),
    ('Ardi');

insert into pembeli(nama_pembeli)
values
    ('ayanis rafaela'),
    ('rizki ardana'),
    ('Fiki Setiawan'),
    ('Varel Ananta'),
    ('Alister bryan ');

insert into transaksi (jumlah_produk, tanggal, id_pegawai, id_pembeli, keterangan)
values
    (2, '12 november 2021', 1, 1, 'Meja nomor 4'),
    (3, '13 november 2021', 2, 2, 'Meja nomor 5'),
    (5, '14 november 2021', 1, 3, 'Dibawa pulang');

insert into detail_transaksi (id_transaksi, id_produk, diskon)
values
    (1, 'AS1', 0),
    (2, 'AP1', 0),
    (3, 'AD1', 10)

drop table if exists produk, pegawai, transaksi;

create table produk(
                       idProduk serial primary key ,
                       namaProduk varchar(15) not null ,
                       harga int not null ,
                       keterangan text
);

create table pegawai(
                        idPegawai serial primary key ,
                        namaPegawai varchar(50) not null
);

create table transaksi(
                          idTransaksi serial primary key ,
                          jmlBarang int not null ,
                          tanggal date,
                          idPegawai int,
                          idProduk int
);

alter table transaksi add foreign key (idPegawai) references pegawai(idPegawai);
alter table transaksi add foreign key (idProduk) references produk(idProduk);

insert into produk(namaProduk, harga, keterangan)
values
    ('Ayama Sayap', 5000, 'Ayam bagian sayap'),
    ('Ayam Paha', 6000, 'Ayam bagain paha'),
    ('Ayam Dada', 6500, 'Ayam bagian dada'),
    ('Es Small', 5000, 'Es ukuran gelas small'),
    ('Es Medium', 8000, 'Es ukuran gelas medium'),
    ('Es Large', 10000, 'Es ukuran gelas large');

insert into pegawai(namaPegawai)
values
    ('Ayani'),
    ('Azka'),
    ('Ardi');

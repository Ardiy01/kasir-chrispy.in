drop table if exists produk, pegawai, transaksi, pembeli;

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


create table pembeli(
                          idPembeli serial primary key ,
                          namaPembeli varchar(20) not null
);

alter table transaksi add foreign key (idPegawai) references pegawai(idPegawai);
alter table transaksi add foreign key (idProduk) references produk(idProduk);


insert into produk(idProduk, namaProduk, harga, keterangan)
values
    (986543, 'Ayama Sayap', 5000, 'Ayam bagian sayap'),
    (989065, 'Ayam Paha', 6000, 'Ayam bagain paha'),
    (965254, 'Ayam Dada', 6500, 'Ayam bagian dada'),
    (928310, 'Es Small', 5000, 'Es ukuran gelas small'),
    (928317, 'Es Medium', 8000, 'Es ukuran gelas medium'),
    (932483, 'Es Large', 10000, 'Es ukuran gelas large');
	
insert into pembeli(idPembeli, namaPembeli)
values 
	(1287, 'ayanis rafaela'), 
	(1398,'rizki ardana'), 
	(1487,'Fiki Setiawan'), 
	(1597, 'Varel Ananta'), 
	(1676, 'Alister bryan ');

insert into Transaksi (idTransaksi, jmlBarang, tanggal, idPegawai,idProduk)
values
	 (23487, 2, '12 november 2021', 45398, 986543),
	 (29787, 3, '13 november 2021', 45378, 989065),
	 (29729, 5, '14 november 2021', 49870, 965254);
select*from Transaksi

insert into pegawai(idPegawai, namaPegawai)
values
    (45398, 'Ayani'),
    (45378, 'Azka'),
    (49870, 'Ardi');
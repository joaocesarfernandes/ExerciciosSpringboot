select 'vendas' as consulta,DTAHORA_EXTRACAO dta_extracao,dtalote,lote,count(1) linhas from SETAT_GENOA_VENDAS
where lote is not null and trunc(dtahora_extracao) >='03-10-2016'
group by lote,DTAHORA_EXTRACAO,dtalote
union
select 'estoque' as consulta,DTA_EXTRACAO,dtalote,lote,count(1) linhas from SETAT_GENOA_ESTOQUE
where lote is not null and trunc(dta_extracao) >='02-10-2016'
group by lote,DTA_EXTRACAO,dtalote
union
select 'compra' as consulta,DTA_EXTRACAO,dtalote,lote,count(1) linhas from SETAT_GENOA_PED_PEND_COMPRA
where lote is not null and trunc(dta_extracao) >='02-10-2016'
group by lote,DTA_EXTRACAO,dtalote
union
select 'faturamento'as consulta,DTA_EXTRACAO,dtalote,lote,count(1) linhas from SETAT_GENOA_PROD_PEND_FAT
where lote is not null and trunc(dta_extracao) >='02-10-2016'
group by lote,DTA_EXTRACAO,dtalote
union
select 'recebimento'as consulta,DTA_EXTRACAO,dtalote,lote,count(1) linhas from SETAT_GENOA_PROD_PEND_REC
where lote is not null and trunc(dta_extracao) >='02-10-2016'
group by lote,DTA_EXTRACAO,dtalote
union
select 'catalogo'as consulta,DTA_EXTRACAO,dtalote,lote,count(1) linhas from SETAT_GENOA_CATALOGO
where lote is not null and trunc(dta_extracao) >='02-10-2016'
group by lote,DTA_EXTRACAO,dtalote
union
select 'catalogo_status'as consulta,DTA_EXTRACAO,dtalote,lote,count(1) linhas from SETAT_GENOA_CATALOGO_STATUS
where lote is not null and trunc(dta_extracao) >='02-10-2016'
group by dta_extracao,lote,dtalote
order by consulta,DTA_EXTRACAO,dtalote,lote; 


select DTA_EXTRACAO dta_extracao,dtalote,lote,count(1) linhas from SETAT_GENOA_CATALOGO
where lote is not null and trunc(dta_extracao) ='03-10-2016'
group by lote,DTA_EXTRACAO,dtalote
order by lote,DTA_EXTRACAO,dtalote;


select to_date(dtalote),count(1) from SETAT_GENOA_CATALOGO
where lote=669
group by to_date(dtalote);




select DTA_EXTRACAO dta_extracao,dtalote,lote,count(1) linhas from SETAT_VERAX_PED_COMPRA
where lote is not null and trunc(dta_extracao) ='03-10-2016'
group by lote,DTA_EXTRACAO,dtalote
order by lote,DTA_EXTRACAO,dtalote;


select * from SETAT_VERAX_PED_COMPRA;




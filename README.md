<<<<<<< HEAD
# kodluyoruz-bitirme-odevi-chambi
kodluyoruz-bitirme-odevi-chambi created by GitHub Classroom

# Arkadaşlar, sabah kahvaltıdan önce bir "PUL" yapın, kodlamaya başlamadan önce, daha sağlıklı olur  :) ^_^
=======

# **CHAMBI KÜTÜPHANESİ**

# You can access the link ->  https://chambi-library.herokuapp.com/ 


## _Kütüphane Kitap Yönetim Sistemi_


## **Gereksinimler**
---
*	Spring Boot

*	Spring Security

*	Spring Web

*	Spring Data 

*	JPA - Hibernate

*	MySQL

*	Lombok

*	Ön yüz olarak Thymeleaf

*	Devtools

*	Modelmapper

## **Uygulama Özellikleri** 
---
*	Ana ekranımızda bir text giriş alanı olacak. Buraya kitap adı yazılıp, sistemde olup olmadığı bilgisine ulaşılabilecek. Eğer kayıtlı bir kullanıcıysa kitabı ÖDÜNÇ AL butonuyla alabilecek.

*	 Sisteme kayıtlı bir kullanıcı değilse ÖDÜNÇ AL butonunu kullanamaz.

*	Kütüphanemizde 2 tane rolümüz olacak.

    * Kütüphane Yetkilisi(Admin)
    * Üye(User)	

*	Sisteme kayıt olmak için kayıt formu sayfasına yönlendirme yapılacak.Gerekli bilgiler girildikten sonra login olunacak. Bu sayede tüm kitap listesine, tüm yazar bilgisine ulaşabilecek ve isterse kendi bilgilerini güncelleyebilecek.

*	 Sisteme girdikten sonra ekrandaki arama alanında dilerse kitap adını girip arama gerçekleştirebilir. Kitap ACTIVE ise ÖDÜNÇ AL butonunu kullanabilir. 

*	Kullanıcı sisteme kullanıcı adı-şifre kombinasyonu ile girebilir. 

*	Kütüphane yetkilisi sisteme kullanıcı adı-şifre kombinasyonuyla giriş yapabilir.

*	Kütüphane yetkilimiz yeni kitap ve yeni yazar ekleme,silme,güncelleme yetkilerine sahiptir. Sistemdeki bütün üyelerin bilgilerini de yine kütüphane yetkilimiz görebilir.

*	Bir kitap,bir yazar yada üye silinmek istenirse veritabanında ki durumu “DELETED” olarak değiştirilecek.

*	Bir üye yada admin giriş yapmamışsa ekranda sadece kitap listesi,yazar listesi,kayıt,giriş ve arama alanlarına erişebilir.


## **Modeller**
---
1.	Member

2.	Book

3.	Author

4.	Role

**1-Member**

*	ID(Primary Key)

*	Kişinin ismi(firstName)

*	Kişinin soyismi(lastName)

*	Kullanıcı adı(userName,unique)

*	Şifresi(password)

*	Email(email,unique)

*	Telefon numarası(phoneNumber)

*	Adres(adress)

*	Kayıt Tarihi(createDate)

*   Güncellenme Tarihi(updateDate)

*	Statüsü(ACTIVE,DELETED)

*	Aldığı kitaplar(books)

*	Sahip olduğu yetkiler(roles)

**2-Book**

*	ID(Primary Key)

*	Kitap ismi(bookName)

*	Kitap Yazarı(authors)

*	Sayfa Sayısı(pageNumber)

*	Yayın evi(publisherName)

*	Baskı sayısı(editionNumber)

*	Barkod(ISBN,unique)

*	Dili(language)

*	Türü(category)

*	Oluşturulma tarihi(createDate)

*	Güncellenme tarihi(updateDate)

*	Statüsü(ACTIVE,PASSIVE,DELETED)

*	Kitap hangi kullanıcıda(member)


**3-Author**

*	ID(Primary Key)

*	Yazar Adı(name)

*	Yazar hakkında(about) 

*	Kayıt Tarihi(createDate)

*	Güncellenme Tarihi(updateDate)

*	Statüsü(ACTIVE,DELETED)

**4-Role**

*	ID(Primary Key)

*	İsmi(roleName)

*	Statüsü(ACTIVE,DELETED)

*	Kayıt Tarihi(createDate)

*	Güncellenme Tarihi(updateDate)

*	Yetkiler hangi kullanıcılarda(members)


### **KİTAP-YAZAR İLİŞKİSİ**
---
* Birçok kitabın birden çok yazarı olacağı gibi birçok yazarın da birden fazla kitabı olabilir.(**_ManyToMany_**)

### **KİTAP-ÜYE İLİŞKİSİ**
---
* Bir üye birden çok kitap ödünç alabilir (OneToMany)
* Birden fazla kitapta bir üye tarafından alınabilir.(**_ManyToOne_**)

### **ÜYE-ROLE İLİŞKİSİ**
---

* Birden çok rolün birden fazla sahibi olacağı gibi birçok üyenin de birden fazla rolü(yetkisi) olabilir.(**_ManyToMany_**)


>>>>>>> 031bd0211c132b6fe69d4b40f4b61f5ec1fc23d1

# **CHAMBI KÜTÜPHANESİ**

# You can access the link ->  http://chambi-library.herokuapp.com/


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
*   Sisteme kayıt olunduğunda default olarak **USER** rolü ile kayıt olunur.
    
*   Sistemin tüm yetkilerinden sorumlu sadece bir **ADMIN** vardır. 

    * Kullanıcı adı :admin
    * Şifre : admin

*	Ana ekranımızda bir text giriş alanı olacak. Buraya kitap adı yazılıp, sistemde olup olmadığı bilgisine ulaşılabilecek. Eğer kayıtlı bir kullanıcıysa kitabı **ÖDÜNÇ AL** butonuyla alabilecek.

*	Sisteme kayıtlı bir kullanıcı değilse **ÖDÜNÇ AL** butonunu kullanamaz.

*	Kütüphanemizde 2 tane rolümüz olacak.

    * Kütüphane Yetkilisi(Admin)
    * Üye(User)	

*	Sisteme kayıt olmak için kayıt formu sayfasına yönlendirme yapılacak.Gerekli bilgiler girildikten sonra **LOGIN** olunacak. Bu sayede tüm kitap listesine, tüm yazar bilgisine ulaşabilecek ve isterse kendi bilgilerini güncelleyebilecek.

*	Sisteme girdikten sonra ekrandaki arama alanında dilerse kitap adını girip arama gerçekleştirebilir. Kitap **ACTIVE** ise **ÖDÜNÇ AL** butonunu kullanabilir. 

*   Kitap ÖDÜNÇ alındıktan sonra durumu **PASSIVE** olarak güncellenecek. İADE edildiğinde tekrar **ACTIVE** görünecek. 

*	Kullanıcı sisteme kullanıcı adı-şifre kombinasyonu ile girebilir. 

*	Kütüphane yetkilisi sisteme kullanıcı adı-şifre kombinasyonuyla giriş yapabilir.

*	Kütüphane yetkilimiz yeni kitap ve yeni yazar ekleme,silme,güncelleme yetkilerine sahiptir. Sistemdeki bütün üyelerin bilgilerini de yine kütüphane yetkilimiz görebilir.

*	Bir kitap,bir yazar ya da üye silinmek istenirse veritabanında ki durumu **DELETED** olarak değiştirilecek. Ancak veritabanındaki bilgileri saklanmaya devam edecek.

*	Bir üye ya da admin giriş yapmamışsa ekranda sadece kitap listesi,yazar listesi,kayıt,giriş ve arama alanlarına erişebilir.


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
* Bir üye birden çok kitap ödünç alabilir (**_OneToMany_**)
* Birden fazla kitapta bir üye tarafından alınabilir.(**_ManyToOne_**)

### **ÜYE-ROLE İLİŞKİSİ**
---

* Birden çok rolün birden fazla sahibi olacağı gibi birçok üyenin de birden fazla rolü(yetkisi) olabilir.(**_ManyToMany_**)



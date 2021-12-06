RPC nedir?
Uzak yordam çağrısı (ya da uzak prosedür çağrısı; İngilizce: Remote Procedure Call (RPC), 
bir diğer adres uzayı (genelde ağ paylaşımlı bilgisayarlar) üzerinde programcı açıkça bu uzaktan etkileşim detayları 
kodlama olmadan çalıştırmak için bir alt yordam veya prosedürü sağlayan bilgisayar programına izin veren süreçler arası 
iletişim teknolojisidir. Sunucu üzerindeki servisleri kontrol ettiğimizde karşımıza çıkan RPC, 
arka plânda birçok şeyi gerçekleştiren bir servistir. RPC, temelde istemci ve sunucu arasında yapılan işlemlerin iletişimi 
için tasarlandı. Bir işlemin gerçekleşmesi için bir gönderici (sunucu) ve bir de istemci vardır.

Multicast nedir?
Multicast, aynı akışın birden fazla alıcıya gönderilmesi sırasında bant genişliğinden tasarruf sağlayabilmek için 
akışın sadece bir kopyasının ağa gönderilmesi işlemine denir.

Nasıl çalıştığına dair ilgili fotoğraf MulticastRpc.png olarak klasörün içerisinde bulunmaktadır.

Proje dosyası MulticastRPC klasörünün içerisindedir. 

Proje nasıl çalışır?
1-) İlk önce istenildiği kadar terminalden StreamReciever.java dosyaları çalıştırılır.
2-) Daha sonra StreamSender.java dosyası çalıştırıır ve bütün stream recieverlara istenilen mesaj gönderilir.
Örnek fotoğraf klasörün içerisindeki "GetMessage.png" dosyasının içerisindedir.

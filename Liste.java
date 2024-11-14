package LinkedList4;

//& Çift Yönlü Dairesel Bağlı Liste
public class Liste {
    Node head = null;
    Node tail = null;

    void basaEkle(int data) {// ^ Başa Ekle
        Node eleman = new Node(data);
        if (head == null) { // Eğer liste boşsa, yani hiç düğüm yoksa
            head = eleman;
            tail = eleman;
            head.next = tail; // Başın next'i tail'e işaret eder
            tail.prev = head; // Tail'in prev'i başa işaret eder
            head.prev = tail; // Başın prev'i tail'e işaret eder (dairesel yapı)
            tail.next = head; // Tail'in next'i başa işaret eder (dairesel yapı)
        } else {
            eleman.next = head; // Yeni düğümün next'i eski başa işaret eder
            head.prev = eleman; // Eski başın prev'i yeni düğüme işaret eder
            head = eleman;
            tail.next = head; // Tail'in next'i yeni başa işaret eder (dairesel yapı)
            head.prev = tail; // Başın prev'i tail'e işaret eder (dairesel yapı)
        }
    }

    void sonaEkle(int data) {// ^ Sona Ekle
        Node eleman = new Node(data);
        if (head == null) { // Eğer liste boşsa
            head = eleman;
            tail = eleman;
            head.next = tail; // Başın next'i tail'e işaret eder
            tail.prev = head; // Tail'in prev'i başa işaret eder
            head.prev = tail; // Başın prev'i tail'e işaret eder (dairesel yapı)
            tail.next = head; // Tail'in next'i başa işaret eder (dairesel yapı)
        } else {
            tail.next = eleman; // Tail'in next'i yeni düğüme işaret eder
            eleman.prev = tail; // Yeni düğümün prev'i eski tail'e işaret eder
            tail = eleman;
            tail.next = head; // Tail'in next'i başa işaret eder (dairesel yapı)
            head.prev = tail; // Başın prev'i yeni tail'e işaret eder (dairesel yapı)
        }
    }

    void arayaEkle(int data, int index) {// ^Araya Ekle
        Node eleman = new Node(data);
        if (head == null) {
            head = eleman;
            tail = eleman;
            head.next = tail; // Başın next'i tail'e işaret eder
            tail.prev = head; // Tail'in prev'i başa işaret eder
            head.prev = tail; // Başın prev'i tail'e işaret eder (dairesel yapı)
            tail.next = head; // Tail'in next'i başa işaret eder (dairesel yapı)
        } else if (index == 0) {
            basaEkle(data);
        } else {
            Node temp = head; // Geçici bir düğüm değişkeni oluşturulur ve başa işaret eder
            int n = 0; // sayaç
            // İndeks yerine ulaşana kadar temp'i ileri taşırız
            // (temp.next != head ile dairesel yapıyı kontrol ediyoruz)
            while (n < index - 1 && temp.next != head) {
                n++;
                temp = temp.next;
            }
            if (temp == tail) { // Eğer indeks tail'in sonrasına geliyorsa
                sonaEkle(data);
            } else {
                eleman.next = temp.next; // Yeni düğümün next'i temp'in bir sonraki düğümüne işaret eder
                eleman.prev = temp; // Yeni düğümün prev'i temp'e işaret eder
                temp.next.prev = eleman; // Temp'in bir sonraki düğümünün prev'i yeni düğüme işaret eder
                temp.next = eleman; // Temp'in next'i yeni düğüme işaret eder
            }
        }
    }

    void bastanSil() {// ^Baştan Sil
        if (head == null) {
            System.out.println("Liste boş");
        } else if (head == tail) {// Eğer listede sadece bir düğüm varsa
            head = null;
            tail = null;
        } else {
            head = head.next;// Head'i bir sonraki düğüme kaydır
            head.prev = tail;// Head'in tail'e işaret ettir
            tail.next = head;// Tail'in next'ini yeni başa işaret ettir
        }
    }

    void sondanSil() {// ^Sondan Sil
        if (head == null) {
            System.out.println("Liste zaten boş");
        } else if (head == tail) { // Eğer listede sadece bir düğüm varsa
            head = null;
            tail = null;
        } else {
            tail = tail.prev; // Tail'i bir önceki düğüme kaydır
            tail.next = head; // Yeni tail'in next'ini başa işaret ettir (dairesel bağlantı)
            head.prev = tail; // Başın prev'ini yeni tail'e işaret ettir
        }
    }

    void aradanSil(int index) {
        if (head == null) {
            System.out.println("Liste zaten boş");
        } else {// Liste boş değil
            if (index == 0 && head == tail) {// Listedeki tek elemanı silme
                head = null;
                tail = null;
            } else if (index == 0 && head != tail) {// Listenin başına denk geliyorsa
                bastanSil();
            } else {// Başa denk gelmiyorsa
                Node temp = head;
                int n = 0;
                while (n < index && temp != tail) {// Listeyi sayma
                    n++;
                    temp = temp.next; // Bir sonraki düğüme geçiş
                }
                if (temp == tail) {// Listenin sonuna denk geliyorsa
                    sondanSil();
                } else {// Ne sona ne de başa denk gelmiyorsa(ortada bir eleman silinecek)
                    temp.prev.next = temp.next; // Silinecek düğümün önceki düğümünün next'ini güncelle
                    temp.next.prev = temp.prev; // Silinecek düğümün sonraki düğümünün prev'ini güncelle
                }
            }
        }
    }

    void yazdir() {// ^Yazdır
        if (head == null) { // Eğer liste boşsa
            System.out.println("Liste boş");
        } else {
            Node temp = head; // Geçici bir düğüm başa işaret eder
            System.out.print("[");
            while (temp != tail) { // Tail'e kadar tüm düğümleri sırayla yazdırır
                System.out.print(temp.data + " ");
                temp = temp.next; // Bir sonraki düğüme geçiş
            }
            System.out.print(temp.data + "]"); // Tail düğümünü de yazdırır ve listeyi kapatır
        }
    }

    void terstenYazdir() {// ^Tersten Yazdır
        if (head == null) { // Eğer liste boşsa
            System.out.println("Liste boş");
        } else {
            Node temp = tail; // Geçici bir düğüm tail'e işaret eder
            System.out.print("[");
            while (temp != head) { // Baş düğüme kadar tüm düğümleri sırayla yazdırır
                System.out.print(temp.data + " ");
                temp = temp.prev; // Bir önceki düğüme geçiş
            }
            System.out.print(temp.data + "]"); // Baş düğümünü de yazdırır ve listeyi kapatır
        }
    }

}

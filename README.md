# bai tap chuong 8

## bai 8.1 - push

Deck quan ly hai danh sach observer. Khi rut bai, Deck gui la vua rut cho DrawLogger va gui so la moi cho SizeStatus. Khi dat mot la len bo bai, chi SizeStatus nhan thong bao. Khi xao bai, bo bai duoc tao lai du 52 la. Neu so la thay doi thi SizeStatus in ra 52.

## bai 8.2 - pull

Deck bao cho observer biet co thay doi. DrawLogger goi lastDrawn() qua DrawView, con SizeStatus goi size() qua SizeView. Deck luu la vua rut truoc khi bao cho DrawLogger. Moi observer chi thay phuong thuc doc minh can, nen khong the goi draw(), push() hay shuffle() qua view nhan duoc.

## bai 8.3 - observer o lop cha

AbstractObservableDeck quan ly viec dang ky, huy dang ky va gui thong bao. Deck ke thua lop nay va goi cac ham thong bao sau khi thay doi bo bai. Bai nay dung lai observer cua bai 8.1.

- uu diem: phan quan ly observer nam chung mot cho, cac lop con co the dung lai.
- nhuoc diem: Deck phai ke thua lop cha nay va khong the ke thua them mot lop khac. Khi them thao tac moi vao Deck, van phai nho goi ham thong bao neu co thay doi.

## bai 8.4 - observer o lop con

Deck giu cac thao tac co ban. ObservableDeck ke thua Deck, goi lai thao tac cua lop cha roi thong bao cho observer. Bai nay cung dung lai observer cua bai 8.1.

- uu diem: co the dung Deck rieng hoac dung ObservableDeck khi can theo doi.
- nhuoc diem: lop con phai theo sat cac thao tac cua lop cha. Neu lop cha them thao tac lam doi so la, lop con co the bo sot thong bao.
- luu y: khi tao doi tuong, ham khoi tao cua Deck goi shuffle(). Luc nay danh sach observer cua lop con chua duoc khoi tao nen phai kiem tra truoc khi gui thong bao.

## cach chay

Mo PowerShell tai thu muc Chapter8, dung JDK 21 tro len.

```powershell
New-Item -ItemType Directory -Force out | Out-Null
$files = (Get-ChildItem src -Recurse -Filter *.java).FullName
javac -encoding UTF-8 -d out $files
java -ea -cp out ex81.Main
java -ea -cp out ex82.Main
java -ea -cp out ex83.Main
java -ea -cp out ex84.Main
```

Ca bon bai deu thu cung mot tinh huong. Lan rut dau in la vua rut va so 51. Dat lai la do thi in 52. Lan rut tiep theo lai in la vua rut va so 51. Xao bo bai thi in 52. Xao them lan nua khi da du 52 la thi khong in them dong nao.

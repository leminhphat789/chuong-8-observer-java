# Bài tập chương 8

## Bài 8.1 – Push

`Deck` quản lý hai danh sách observer. Khi rút bài, `Deck` gửi lá vừa rút cho `DrawLogger` và gửi số lá còn lại cho `SizeStatus`. Khi đặt một lá lên bộ bài, chỉ `SizeStatus` nhận thông báo. Khi xáo bài, bộ bài được tạo lại đủ 52 lá. Nếu số lá thay đổi thì `SizeStatus` in ra 52.

## Bài 8.2 – Pull

`Deck` báo cho observer biết khi có thay đổi. `DrawLogger` gọi `lastDrawn()` qua `DrawView` để lấy lá vừa rút, còn `SizeStatus` gọi `size()` qua `SizeView` để lấy số lá còn lại. `Deck` lưu lá vừa rút trước khi báo cho `DrawLogger`. Mỗi observer chỉ thấy phương thức đọc mình cần nên không thể gọi `draw()`, `push()` hay `shuffle()` qua giao diện nhận được.

## Bài 8.3 – Observer ở lớp cha

`AbstractObservableDeck` quản lý việc đăng ký, hủy đăng ký và gửi thông báo. `Deck` kế thừa lớp này và gọi phương thức thông báo sau khi thay đổi bộ bài. Bài này dùng lại các observer của bài 8.1.

- **Ưu điểm.** Phần quản lý observer nằm ở một chỗ nên các lớp con có thể dùng lại.
- **Nhược điểm.** Khi đã kế thừa `AbstractObservableDeck`, `Deck` không thể kế thừa thêm một lớp khác. Khi thêm thao tác làm thay đổi bộ bài, người viết vẫn phải nhớ gọi phương thức thông báo phù hợp.

## Bài 8.4 – Observer ở lớp con

`Deck` giữ các thao tác cơ bản. `ObservableDeck` kế thừa `Deck`, gọi phương thức của lớp cha rồi thông báo cho observer. Bài này cũng dùng lại các observer của bài 8.1.

- **Ưu điểm.** Có thể dùng `Deck` riêng hoặc dùng `ObservableDeck` khi cần theo dõi bộ bài.
- **Nhược điểm.** Lớp con phải theo sát các thao tác của lớp cha. Nếu lớp cha có thêm thao tác làm đổi số lá, lớp con có thể bỏ sót thông báo.
- **Lưu ý khi khởi tạo.** Hàm khởi tạo của `Deck` gọi `shuffle()`. Lúc này danh sách observer của lớp con chưa được khởi tạo nên cần kiểm tra trước khi gửi thông báo.

## Cách chạy

Mở PowerShell tại thư mục `Chapter8` và chạy các lệnh sau với JDK 21 trở lên.

```powershell
New-Item -ItemType Directory -Force out | Out-Null
$files = (Get-ChildItem src -Recurse -Filter *.java).FullName
javac -encoding UTF-8 -d out $files
java -ea -cp out ex81.Main
java -ea -cp out ex82.Main
java -ea -cp out ex83.Main
java -ea -cp out ex84.Main
```

Cả bốn bài đều thử cùng một tình huống. Lần rút đầu tiên in ra lá vừa rút và số lá còn lại là 51. Đặt lá đó trở lại bộ bài thì số lá tăng lên 52. Lần rút tiếp theo lại in ra lá vừa rút và số 51. Xáo bài lần đầu đưa bộ bài về đủ 52 lá nên chương trình in ra 52. Xáo thêm lần nữa khi đã đủ 52 lá thì chương trình không in thêm dòng nào.

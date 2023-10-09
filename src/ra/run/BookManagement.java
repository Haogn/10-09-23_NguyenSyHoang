package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static Scanner sc = new Scanner(System.in);
    public static List<Book> listBook = new ArrayList<>();

    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();

//        Book book1 = new Book(1 , "Truyen kieu", "ccc" , 100, 50F, 100F, true);
//        Book book2 = new Book(2 , "Chi pheo", "ccc" , 100, 60F, 120F, true);
//        listBook.add(book1);
//        listBook.add(book2);
        int choice;
        do {
            System.out.println("_______________JAVA-HACKATHON-05-BASIC-MENU________________");
            System.out.println("1. Nhập số sách và nhập thông tin sách ");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("Lua chon the thua hien quan ly MENU Book ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    bookManagement.createBook();
                    break;
                case 2:
                    bookManagement.printBook();
                    break;
                case 3:
                    bookManagement.sortByPrice();
                    break;
                case 4:
                    bookManagement.deleteById();
                    break;
                case 5:
                    bookManagement.findByName();
                    break;
                case 6:
                    bookManagement.changeStatus();
                    break;
                case 7:
                    System.err.println(" ❌❌❌ Thoat chuong trinh ");
                    sc.close();
                    break;
                default:
                    System.err.println("Lua chon khong phu hop . Vui long nhap lai ❤");
            }

        } while (choice != 7);
    }

    public void createBook() {
        System.out.println("Nhap vao so luong sach muon them vao danh sach ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Book newBook = new Book();
            newBook.inputData();
            listBook.add(newBook);
        }
    }

    public void printBook() {
        if (listBook.isEmpty()) {
            System.out.println("Danh sach dang rong , Hay nhap vao sach them vao danh sach");
            Book newBook = new Book();
            newBook.inputData();
            listBook.add(newBook);
            listBook.get(0).displayData();
        } else {
            for (Book book : listBook) {
                book.displayData();
            }
        }
    }

    public void sortByPrice() {
        listBook.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (int) (o2.getInterest() - o1.getInterest());
            }
        });
        System.out.println("Sap xep theo loi nhuan giam dan ");
        for (Book book : listBook) {
            book.displayData();
        }
    }

    public void deleteById() {
        System.out.println("Nhap vao Id sach can xoa");
        int id = Integer.parseInt(sc.nextLine());
        Book newBook = findById(id);
        if (newBook != null) {
            listBook.remove(newBook);
            System.out.println("Da xoa sach khoi danh sach");
        } else {
            System.err.println("Khong tim thay sach trnong danh sach ");
        }
    }

    public void findByName() {
        System.out.println("Nhap vao ten sach can tim kiem ");
        String search = sc.nextLine();
        for (Book book : listBook) {
            if (book.getBookName().equalsIgnoreCase(search)) {
                System.out.println("Tim thay sach trong danh sach");
                book.displayData();
                break;
            } else {
                System.err.println("Sach khon ton tai ");
                break;
            }
        }
    }

    public void changeStatus() {
        System.out.println("Nhap vao Id sach can thay doi trang thai ban hang");
        int id = Integer.parseInt(sc.nextLine());
        for (Book book : listBook) {
            if (book.getBookId() == id) {
                book.setBookStatus(!book.isBookStatus());
                System.out.println("Trạng thái của mã sách đã đổi thành " + book.isBookStatus());

            }
        }

    }

    public Book findById(int id) {
        for (Book book : listBook) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }
}

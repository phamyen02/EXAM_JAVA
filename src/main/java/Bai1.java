import java.util.*;
import java.util.stream.Collectors;

public class Bai1 {

    public List<Student> taoDanhSachSV() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(01223230, "Nguyễn Văn A", "dothihoa@gmail.com", 7, 6, 7, 8));
        students.add(new Student(01223231, "Nguyễn Văn B", "dothihai@gmail.com", 3, 4, 5, 1.5));
        students.add(new Student(01223232, "Nguyễn Văn C", "dothihuong@gmail.com", 7, 8, 9, 2.5));
        students.add(new Student(01223233, "Nguyễn Văn D", "dothiha@gmail.com", 6, 10, 6.5, 9));
        students.add(new Student(01223234, "Nguyễn Văn E", "dothihong@outlook.com", 1, 8, 8, 5.5));
        students.add(new Student(01223235, "Nguyễn Văn F", "dothia@gmail.com", 3, 8, 8, 5));
        students.add(new Student(01223236, "Nguyễn Văn N", "dothib@gmail.com", 8, 5, 3, 2));
        students.add(new Student(01223237, "Nguyễn Văn M", "dothic@gmail.com", 1, 4, 4, 2.5));
        students.add(new Student(01223255, "Nguyễn Văn L", "dothid@gmail.com", 8, 7, 1, 7));
        students.add(new Student(01223266, "Nguyễn Văn K", "dothie@gmail.com", 3, 6, 7, 4));
        students.add(new Student(01223240, "Nguyễn Văn H", "dothij@gmail.com", 1, 4, 6, 3.5));
        students.add(new Student(01223241, "Nguyễn Văn Y", "dothik@gmail.com", 6, 7, 2, 4));
        students.add(new Student(01223242, "Nguyễn Văn P", "dothil@gmail.com", 8, 7, 2, 7.5));
        students.add(new Student(01223243, "Nguyễn Văn MA", "dothim@gmail.com", 6, 8, 2, 1));
        students.add(new Student(01223244, "Nguyễn Văn Ab", "dothin@gmail.com", 8, 8, 2, 8));
        students.add(new Student(01223245, "Nguyễn Văn AD", "dothio@gmail.com", 6, 5, 4, 3));
        students.add(new Student(01223246, "Nguyễn Văn AN", "dothiu@gmail.com", 7, 3, 6, 7.5));
        students.add(new Student(01223247, "Nguyễn Văn AM", "dothit@gmail.com", 8, 3, 4, 5));
        return students;
    }
    // 2.Liệt kê danh sách 10 sv có điểm thi lý thuyết cao nhất
    public List<Student> listTop10Exam(List<Student> students) throws Exception {
        if(students == null || students.size() < 10) {
            throw new Exception("Invalid size of list student");
        }
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getLT).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    // 3. Tính điểm tổng kết cho từng sinh viên
    public Map<Student,Double> diemTongKet(List<Student> students) throws Exception {
        if(students == null || students.size() == 0) {
            throw new Exception("Invalid size of list student");
        }
        Map<Student,Double> result = new HashMap<>();
        for (Student student: students){
            double mark = student.getBonus()*0.1 + student.getReport()*0.3 + student.getApp()*0.15 + student.getLT()*0.45;
            result.put(student,mark);
        }
        return result;
    }

    // 4. Liệt kê danh sách 10 sv có điểm thấp nhất
    public Map<Student,Double> top10LowesPoint(HashMap<Student,Double> finalPoint) throws Exception {
        if(finalPoint == null || finalPoint.isEmpty()) {
            throw new Exception("Invalid size of list student");
        }
        return finalPoint.entrySet().stream().
                sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    // 6. Hiển thị bảng thống kê
    public static void classStatistic(Map<Student,Double> students) throws Exception {
        if(students == null || students.isEmpty()) {
            throw new Exception("Số lượng sinh viên không hợp lệ");
        }
        System.out.println("Số lượng sinh viên: " + students.size());

        long pass = students.entrySet().stream().filter(x -> x.getValue() > 4.5).count();
        System.out.println("Đạt: " + pass + " Tỉ lệ: " + (double) pass/students.size()*100 + "%" );
        int notPass = (int) (students.size() - pass);
        System.out.println("Không đạt: " + notPass + " Tỉ lệ: " + (double) notPass/students.size()*100 + "%" );

        int Gioi = (int)students.entrySet().stream().filter(x -> x.getValue() >=8 && x.getValue() <=10 ).count();
        int Kha = (int)students.entrySet().stream().filter(x -> x.getValue() >=6.5 && x.getValue() <8 ).count();
        int TrungBinh = (int)students.entrySet().stream().filter(x -> x.getValue() >=5 && x.getValue() <6.5 ).count();

        System.out.println("Giỏi " + Gioi + " Tỉ lệ: " + (double) Gioi/students.size()*100 + "%" );
        System.out.println("Khá " + Kha + " Tỉ lệ: " + (double) Kha/students.size()*100 + "%" );
        System.out.println("Trung bình " + TrungBinh + " Tỉ lệ: " + (double) TrungBinh/students.size()*100 + "%" );
    }
}

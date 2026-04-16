package Bai4;

public class bai4 {
    public static void main(String[] args) {
        String welcomeMsg = """
                =========================
                CHÀO MỪNG BẠN ĐẾN VỚI HỆ THỐNG
                Chúc bạn một ngày tốt lành!
                =========================
                """;
        System.out.println(welcomeMsg);

        String email = """
                Xin chào %s,
                
                Tài khoản của bạn trên hệ thống đã được kích hoạt thành công.
                Vui lòng đăng nhập để tiếp tục.
                
                Trân trọng,
                Admin.
                """.formatted("Nam");
        System.out.println(email);

        String html = """
                <html>
                    <body>
                        <h2>Thông tin sinh viên</h2>
                        <ul>
                            <li>Họ tên: %s</li>
                            <li>Điểm GPA: %.2f</li>
                        </ul>
                    </body>
                </html>
                """.formatted("Nam", 3.8);
        System.out.println(html);

        String sql = """
                SELECT id, name, gpa 
                FROM Students 
                WHERE gpa > 3.0;
                """;
        System.out.println("Câu lệnh SQL:\n" + sql);
    }
}

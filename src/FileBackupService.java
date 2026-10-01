import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileBackupService {
    public void coppyOptimized(String sourcePath, String destPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destPath)) {
            byte[] buffer = new byte[8192];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        FileBackupService service = new FileBackupService();

        String sourceFile = "1.Python 05 27.5.22.mp4";
        String destFile = "taive.mp4";
        try {
            service.coppyOptimized(sourceFile, destFile);
            System.out.println("sao chep thanh cong");
        } catch (IOException e) {
            System.out.println("loi khi sao chep file: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
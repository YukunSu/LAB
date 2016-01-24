import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class RenameFiles {
    private static final String ROOT_DIRECTORY = "C:\\我的文件夹\\迅雷下载\\";
    private static final String PREFIX_1 = "[猪猪字幕组]";
    private static final String PREFIX_2 = "[猪猪字幕组][火影疾风传]";
    private static final String REGEX_1 = "\\]\\[";
    private static final String REGEX_2 = "\\]";
    
    public static void main(String[] args){
        File directory = new File(ROOT_DIRECTORY);
        File[] files1 = directory.listFiles();
        for(int i=0; i<files1.length; i++){
            String folderName = "";
            if(files1[i].isDirectory()){
                folderName = files1[i].getName();
            }

            if(folderName.startsWith(PREFIX_1)){
                File subDirectory = new File(ROOT_DIRECTORY+folderName);
                File[] files2 = subDirectory.listFiles();
                for(int j=0; j<files2.length; j++){
                    String fileName = "";
                    if(files2[j].isFile()){
                        fileName = files2[j].getName();
                    }
                    
                    if(fileName.equals(folderName)){
                        try {
                            String originalFileName = fileName;
                            String[] parts = originalFileName.split(REGEX_1);
                            String[] subParts = parts[4].split(REGEX_2);
                            String extension = subParts[1];
                            String newFileName = "";
                            if(fileName.startsWith(PREFIX_2)){
                                int episodeIntegerNumber = Integer.parseInt(parts[2]);
                                newFileName = "火影忍者 - " + parts[2] + extension;
                            } else {
                                int episodeIntegerNumber = Integer.parseInt(parts[3]);
                                newFileName = parts[3] + extension;
                            }
                            
                            System.out.println(originalFileName + " >>>>>>>> " + newFileName);
                            Path targetFile = Paths.get(ROOT_DIRECTORY+folderName+"\\"+fileName);
                            Files.move(targetFile, targetFile.resolveSibling(ROOT_DIRECTORY + newFileName), StandardCopyOption.REPLACE_EXISTING);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

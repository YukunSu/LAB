import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class RenameFiles {
    public static void main(String[] args){
        File directory = new File("C:\\�ҵ��ļ���\\Ѹ������");
        File[] fList = directory.listFiles();
        for(int i=0; i<fList.length; i++){
            if(fList[i].getName().startsWith("[������Ļ��]")){
                File directory2 = new File("C:\\�ҵ��ļ���\\Ѹ������"+"\\"+fList[i].getName());
                File[] fList2 = directory2.listFiles();
                for(int j=0; j<fList2.length; j++){
                    if(fList2[j].getName().equals(fList[i].getName())){
                        try {
                            String originalName = fList2[j].getName();
                            String[] ss = originalName.split("\\]\\[");
                            String[] sss = ss[4].split("\\]");
                            String last = sss[1];
                            String newName = "";
                            if(fList2[j].getName().startsWith("[������Ļ��][��Ӱ���紫]")){
                                int ii = Integer.parseInt(ss[2]);
                                newName = "��Ӱ���� - " + ss[2] + last;
                            } else {
                                int ii = Integer.parseInt(ss[3]);
                                newName = ss[3] + last;
                            }
                            System.out.println(originalName + ">>>>>>>>" + newName);
                            Path a = Paths.get("C:\\�ҵ��ļ���\\Ѹ������"+"\\"+fList[i].getName()+"\\"+fList2[j].getName());
                            Files.move(a, a.resolveSibling("C:\\�ҵ��ļ���\\Ѹ������\\" + newName), StandardCopyOption.REPLACE_EXISTING);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

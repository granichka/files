package local.nix.files.util;

import java.io.*;

public interface DirUtil {

    static void copyContentOfDirectory(File from, File to) throws IllegalArgumentException {

        if(!checkIfIsDirectory(from) || !checkIfIsDirectory(to)){
            throw  new IllegalArgumentException("DirUtil (copyContentOfDirectory): Был передан файл вместо каталога");
        }

        if(!from.exists()) {
            throw  new IllegalArgumentException("DirUtil (copyContentOfDirectory): Такого каталога " + from.getAbsolutePath() + " не существует");
        }

        copy(from, to);

    }

    private static boolean checkIfIsDirectory(File file){
        return file.isDirectory();
    }

    private static void copy(File from, File to) {

            if(from.isDirectory()) {
                if(!to.exists()) {
                    to.mkdir();
                }
                String[] files = from.list();
                for (String file : files) {
                    File fromFile = new File(from, file);
                    File toFile = new File(to, file);
                    copy(fromFile, toFile);
                }
            } else {
                try(InputStream is = new FileInputStream(from);
                    OutputStream os = new FileOutputStream(to)) {

                        byte[] buffer = new byte[1024];
                        int length;

                        while((length = is.read(buffer)) != -1) {
                            os.write(buffer, 0, length);
                        }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }







}

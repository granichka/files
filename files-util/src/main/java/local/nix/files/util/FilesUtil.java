package local.nix.files.util;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface FilesUtil {

    static void getStringsFromFileThatMatchesRegex(final File file, String regex) {

        File result = new File("getStringsFromFileThatMatchesRegexResult.txt");

        try {
            if(result.exists()) {
                result.delete();
            }
            result.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(result))) {

            String line;
            while((line = br.readLine()) != null){
                bw.write(checkIfStringMatchesRegex(line, regex) + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String checkIfStringMatchesRegex(String stringToCheck, String regex) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        String[] arr = stringToCheck.split("[\\s]*[,:;=][\\s]");
        for (String s : arr) {
            if(s.matches(".+[,;.]")) {
                s = s.substring(0, s.length()-1);
            }
            Matcher matcher = pattern.matcher(s);
            while(matcher.find()) {
                result = matcher.group();
           }
        }
        return result;
    }


}

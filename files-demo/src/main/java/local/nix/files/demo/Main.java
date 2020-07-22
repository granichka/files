package local.nix.files.demo;

import local.nix.files.util.DirUtil;
import local.nix.files.util.FilesUtil;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        File file = new File("from.txt");

        String emailRegex = ".+@[a-z]+[.][a-z]+";

        String phoneRegex = "[+][0-9]{12}";

        String fioRegex = "[а-яА-я]+[\\s][а-яА-я]+[\\s][а-яА-я]+";

        FilesUtil.getStringsFromFileThatMatchesRegex(file, fioRegex);

        File from = new File("test");
        File to = new File("result");
        to.mkdir();
        DirUtil.copyContentOfDirectory(from, to);

    }
}

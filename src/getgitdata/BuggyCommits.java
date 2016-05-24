/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getgitdata;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Masud
 */
public class BuggyCommits {
    public static String rootpath = "I:/Dev/NetbeanProjects/data/getgitdata/";
    
    public static void main(String[] args) {
        BuggyCommits bc = new BuggyCommits();
         GetGitData gitdata = new GetGitData();
         gitdata.setLang(".java");
         //gitdata.getGitLogs("gitlog.bat", "commons-math","1990-01-01");
         ArrayList<String> st = new ArrayList<>();
         ArrayList<MetaCommitData> mcd =new ArrayList<>();
        gitdata.processGitCommitsData("commons-math",rootpath+"gitlogs/commons-math/git_log.txt");
    
    }
  
}

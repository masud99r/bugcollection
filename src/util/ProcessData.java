/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.englishStemmer;

/**
 *
 * @author Masud
 */
public class ProcessData {
    Tokenizer tokenizer ;
    public ProcessData(){
        try {
        tokenizer = new TokenizerME(new TokenizerModel(new FileInputStream("./data/Model/en-token.bin")));
        } catch (IOException e) {
              e.printStackTrace();
        }
    }
public ArrayList<String> TokenizeText(String text){
    ArrayList<String> token_list = new ArrayList<>();
    String[] tokens = tokenizer.tokenize(text);//opennlp tokenizer
    for(String token:tokens){
        if(token.isEmpty()!=true){
            token_list.add(token);
        }
    }
    return token_list;
}
public String ProcessToken(String token){
    String term = Normalization(token);
    term = SnowballStemmingDemo(term);
    return  term;
}
public String SnowballStemmingDemo(String token) {
    SnowballStemmer stemmer = new englishStemmer();
    stemmer.setCurrent(token);
    if (stemmer.stem())
            return stemmer.getCurrent();
    else
            return token;
}
public String Normalization(String token) {
    // remove all non-word characters
    // please change this to removing all English punctuation
    token = token.replaceAll("\\W+", ""); 

    token = token.replaceAll("[^\\p{L}\\p{Nd}]+", ""); //for non-words
    token = token.replaceAll("[-,­.;:!?…()\\\\\\\\{}\\\\[\\\\]<>«»—'“”\\\\\\\"‘’/]", ""); //for Punctuation
    // convert to lower case
    token = token.toLowerCase(); 
    token = token.replaceAll("\\\\d+(\\\\.\\\\d+)?", "NUM"); //replace integer and double
    token = token.replaceAll("\\d", "NUM"); //replace integer and double
    return token;
}
}

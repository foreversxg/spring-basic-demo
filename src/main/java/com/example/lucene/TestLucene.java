package com.example.lucene;

import org.ansj.lucene5.AnsjAnalyzer;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.ChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.apache.lucene.util.Version.LUCENE_45;

public class TestLucene {

    public static void main(String[] args){

        write();
        read();
//        try {
//            test();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void test() throws IOException {
        String str = "1324,454,45,4555" ;
        System.out.println(ToAnalysis.parse(str));

    }

    public static void write() {
        IndexWriter writer = null ;
        try {
            Directory dir = FSDirectory.open(new File("E:/lucene/indexed"));
            writer = new IndexWriter(dir, new IndexWriterConfig(LUCENE_45, new AnsjAnalyzer(AnsjAnalyzer.TYPE.base_ansj))) ;
            Document document = new Document();
            document.add(new StringField("name","tom",Field.Store.YES));
            document.add(new TextField("age","1456456,787543",Field.Store.YES));
            document.add(new TextField("des","tom is 13",Field.Store.YES));
            writer.updateDocument(new Term("name","tom"),document);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void read() {
        try {
            //1.创建Directory
            Directory dir = FSDirectory.open(new File("E:/lucene/indexed"));
            //2.创建IndexReader
            IndexReader reader = DirectoryReader.open(dir) ;
            //3.根据IndexReader创建IndexSearcher
            IndexSearcher searcher = new IndexSearcher(reader) ;
            //4.创建搜索的Query
            //创建parser来确定搜索的内容,第二个参数表示搜索的域
            QueryParser parser = new QueryParser(Version.LUCENE_45,"content", new StandardAnalyzer(Version.LUCENE_45)) ;
            //创建query，表示搜索域中包含'Directory'的文档
            Query query = new TermQuery(new Term("age","1456456"));
            //5.根据search搜索返回TopDocs，要设置返回条数
            TopDocs docs = searcher.search(query, 10) ;
            //6.根据TopDocs获取ScoreDoc
            for(ScoreDoc doc: docs.scoreDocs){
                //7.根据searcher和scoredoc获取具体的Document对象
                Document document = searcher.doc(doc.doc) ;
                //8.根据Document对象获取需要的内容
                System.out.println(document.get("name")+"["+document.get("age")+"]");
            }
            //9.关闭reader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

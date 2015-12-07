package unify;

/**
 * Created by shimtom on 15/11/19.
 *
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Created by shimtom on 15/11/10.
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Created by shimtom on 15/11/10.
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 ***/
/***
 * Created by shimtom on 15/11/10.
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 * <p/>
 * Unify Program written
 * <p/>
 * <p/>
 * <p/>
 * 変数:前に？をつける．
 * <p/>
 * Examle:
 * % Unify "Takayuki" "Takayuki"
 * true
 * <p/>
 * % Unify "Takayuki" "Takoyuki"
 * false
 * <p/>
 * % Unify "?x am Takayuki" "I am Takayuki"
 * ?x = I .
 * <p/>
 * % Unify "?x is ?x" "a is b"
 * false
 * <p/>
 * % Unify "?x is ?x" "a is a"
 * ?x = a .
 * <p/>
 * % Unify "?x is a" "b is ?y"
 * ?x = b.
 * ?y = a.
 * <p/>
 * % Unify "?x is a" "?y is ?x"
 * ?x = a.
 * ?y = a.
 * <p/>
 * Unify は，ユニフィケーション照合アルゴリズムを実現し，
 * パターン表現を比較して矛盾のない代入によって同一と判断
 * できるかどうかを調べる．
 * <p/>
 * ポイント！
 * ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 * しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 * 単一化において出現検査を行う必要がある．
 * 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 * 無限ループに陥ってしまう．
 ***/

/***
 Unify Program written



 変数:前に？をつける．

 Examle:
 % Unify "Takayuki" "Takayuki"
 true

 % Unify "Takayuki" "Takoyuki"
 false

 % Unify "?x am Takayuki" "I am Takayuki"
 ?x = I .

 % Unify "?x is ?x" "a is b"
 false

 % Unify "?x is ?x" "a is a"
 ?x = a .

 % Unify "?x is a" "b is ?y"
 ?x = b.
 ?y = a.

 % Unify "?x is a" "?y is ?x"
 ?x = a.
 ?y = a.

 Unify は，ユニフィケーション照合アルゴリズムを実現し，
 パターン表現を比較して矛盾のない代入によって同一と判断
 できるかどうかを調べる．

 ポイント！
 ここでは，ストリング同士の単一化であるから，出現検査を行う必要はない．
 しかし，"?x is a"という表記を"is(?x,a)"とするなど，構造を使うならば，
 単一化において出現検査を行う必要がある．
 例えば，"a(?x)"と"?x"を単一化すると ?x = a(a(a(...))) となり，
 無限ループに陥ってしまう．

 ***/

import java.util.*;
import java.io.*;
import java.lang.*;

class Unify {

    public static void main(String args[]) {
        if (args.length > 0 ){
            Unify object = new Unify();
            object.openFile("/home/shimtom/Documents/IntelliJ/report4/example.txt");
            object.search(args);
            object.print();

        } else {
            System.out.println("Usgae : % Unify [string1] [string2]");
        }
    }

    /**
     * コンストラクタ。
     */
    Unify(){
        buffer = new ArrayList<String>();
        result = new ArrayList<String>();
    }


    /**
     * コンストラクタ。sentencesを条件文で初期化
     */
    Unify(String string) {
        buffer = new ArrayList<String>();
        result = new ArrayList<String>();
        fileName=string;
        openFile(fileName);
    }

    /**
     * データベースを開く
     * @param string データベースのファイル名
     */
    public void openFile(String string){
        try {
            File file = new File(string);
            if (!file.canRead()) return;
            fileName = string;
            buffer = new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();
            while (str != null) {
                if(!str.isEmpty()) buffer.add(str);
                str = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * データベースをファイルに保存
     */
    public void saveFile(){
        saveFile(fileName);
    }


    /**
     * データベースをファイルに保存
     *
     * @param string ファイルの絶対パス
     */
    public void saveFile(String string){
        try {
            File file = new File(string);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String line : buffer) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * データベースの末尾にデータを追加する。
     *
     * @param strings 追加するデータの配列
     */
    public void add(String ...strings){
        buffer.addAll(Arrays.asList(strings));
    }

    /**
     * データベースの指定した位置にデータを挿入する。
     *
     * @param index 挿入する位置
     * @param strings 挿入するデータ
     */
    public void insert(int index,String ...strings){
        buffer.addAll(index,Arrays.asList(strings));
    }


    /**
     * 条件に合うデータをデータベースから削除
     * @param strings 条件文
     */
    public void delete(String ...strings){
        ArrayList<String> newBuffer = new ArrayList<String>();
        search(strings);
        for (String string:result){
            for(String line : buffer){
                if (!line.equals(string)) newBuffer.add(line);
            }
        }
        buffer=newBuffer;
    }

    /**
     * 指定された位置のデータをデータベースから削除する。
     *
     * @param index 削除する位置
     */
    public void remove(int index){
        buffer.remove(index);
    }

    /**
     * データベースをクリア
     */
    public void clear(){
        buffer.clear();
    }

    /**
     * データベースを与えられたデータで初期化
     * @param newBuffer 初期データ
     */
    public void set(String ...newBuffer){
        buffer.clear();
        buffer.addAll(Arrays.asList(newBuffer));
    }

    /**
     * 条件文に合うデータをデータベースから検索
     *
     * @param strings 条件文
     * @return 検索した条件文の結果を返す
     */
    public String[] search(String ...strings) {
        varsSet = new HashSet<HashMap<String, String>>();
        sentences = strings;
        result = new ArrayList<String>();

        /*
        1. 条件文ごとに、参照文ごとの変数集合"map"を用意。
        2. 条件文ごとに変数集合の集合"set"を用意
        3. unify()を使用し変数集合"map"を完成。
        4. setに"map"を追加
        3. varsSet >= set > map
         */
        for (String sentence : sentences) {
            HashSet<HashMap<String, String>> set = new HashSet<HashMap<String, String>>();
            int size = varsSet.size();
            for (Iterator it = varsSet.iterator(); it.hasNext() || size == 0; ) {
                HashMap<String, String> map;
                if (size == 0) map = new HashMap<String, String>();
                else map = (HashMap<String, String>) it.next();

                for (String string : buffer)
                    if (unify(sentence, string,map)) set.add(vars);

                if (size == 0) break;
            }
            //コピー
            varsSet.clear();
            varsSet.addAll(set);
        }

        //一致した文をresult[]に追加
        for (HashMap<String, String> map : varsSet) {
            for (String sentence : sentences) {
                StringTokenizer tokenizer = new StringTokenizer(sentence);
                int length = tokenizer.countTokens();
                String tokens[] = new String[length];
                String string = "";

                for (int i = 0; i < length; i++)
                    tokens[i] = tokenizer.nextToken();

                for (int i = 0; i < length; i++)
                    if (var(tokens[i])) tokens[i] = map.get(tokens[i]);

                for (int i = 0; i < length - 1; i++)
                    string += (tokens[i] + " ");
                string += tokens[length - 1];

                result.add(string);
            }
        }
        return result.toArray(new String[0]);
    }

    /**
     * 検索した条件文の結果を返す。
     */
    public String[] getResult(){
        return result.toArray(new String[0]);
    }

    /**
     * データベースを取得
     */
    public String[] getData(){
        return buffer.toArray(new String[0]);
    }

    /**
     * 条件文リストをすべて満たすような変数集合とセンテンスを表示する。
     */
    void print() {
        System.out.println("Conditional");
        for (String sentence : sentences) System.out.println("  " + sentence);
        System.out.println();

        for (HashMap<String, String> map : varsSet) {
            System.out.println(map.toString());
            for (String sentence : sentences) {
                StringTokenizer tokenizer = new StringTokenizer(sentence);
                int length = tokenizer.countTokens();
                String tokens[] = new String[length];
                String string = "";

                for (int i = 0; i < length; i++)
                    tokens[i] = tokenizer.nextToken();

                for (int i = 0; i < length; i++)
                    if (var(tokens[i])) tokens[i] = map.get(tokens[i]);

                for (int i = 0; i < length - 1; i++)
                    string += (tokens[i] + " ");
                string += tokens[length - 1];

                System.out.println("  " + string);
            }
        }
    }


    /**
     * ユニフィケーション照合アルゴリズムを利用して、条件文と参照文のパターンが一致するか調べる。<br>
     * 変数集合の初期化が可能
     *
     * @param string1 条件文
     * @param string2 参照文
     * @param bindings 変数集合
     * @return 条件文と参照文が一致するなら真。そうでなければ偽
     */
    private boolean unify(String string1, String string2, HashMap<String, String> bindings) {
        vars = new HashMap<String, String>(bindings);
        return unify(string1, string2);
    }

    /**
     * ユニフィケーション照合アルゴリズムを利用して、条件文と参照文のパターンが一致するか調べる。
     *
     * @param string1 条件文
     * @param string2 参照文
     * @return 条件文と参照文が一致するなら真。そうでなければ偽。
     */
    private boolean unify(String string1, String string2) {
        // 同じなら成功
        if (string1.equals(string2)) {
            return true;
        }
        StringTokenizer tokenizer1 = new StringTokenizer(string1);
        StringTokenizer tokenizer2 = new StringTokenizer(string2);
        // 数が異なったら失敗
        if (tokenizer1.countTokens() != tokenizer2.countTokens()) return false;
        tokens1 = new String[tokenizer1.countTokens()];
        tokens2 = new String[tokenizer2.countTokens()];

        int length = tokenizer1.countTokens();

        for (int i = 0; i < length; i++) {
            tokens1[i] = tokenizer1.nextToken();
            tokens2[i] = tokenizer2.nextToken();
        }

        for (int i = 0; i < length; i++)
            if (!tokenMatching(tokens1[i], tokens2[i])) return false;

        return true;
    }

    /**
     * 条件文と参照文のトークンが比較する。
     *
     * @param token1 条件文トークン
     * @param token2 参照文トークン
     * @return 条件文トークンと参照文トークンが一致すれば真。そうでなければ偽。
     */
    private boolean tokenMatching(String token1, String token2) {
        if (token1.equals(token2)) return true;
        else if (var(token1) && !var(token2)) return varMatching(token1, token2);
        else if (!var(token1) && var(token2)) return varMatching(token2, token1);
        else return var(token1) && var(token2) && varMatching(token1, token2);
    }

    /**
     * 変数に割り当てられている値が正しいか調べる。<br>
     * 変数が未出場であった場合は、その変数と値を変数集合に追加する。
     *
     * @param varToken 変数トークン
     * @param token 対照トークン
     * @return 変数に割り当てられている値が正しいなら真。そうでなければ偽。
     */
    private boolean varMatching(String varToken, String token) {
        if (vars.containsKey(varToken)) {
            return token.equals(vars.get(varToken));
        } else {
            replaceBuffer(varToken, token);
            if (vars.containsValue(varToken))
                replaceBindings(varToken, token);
            vars.put(varToken, token);
            return true;
        }
    }


    /**
     * 条件文の変数トークンを対照となる参照文のトークンのと入れ替える。<br>
     * あるいは、参照文の変数トークンを対照となる条件文のトークンと入れ替える。
     *
     * @param varToken 変数トークン
     * @param token 対照トークン
     */
    private void replaceBuffer(String varToken, String token) {
        for (int i = 0; i < tokens1.length; i++) {
            if (varToken.equals(tokens1[i])) tokens1[i] = token;
            if (token.equals(tokens2[i])) tokens2[i] = varToken;
        }
    }


    /**
     * 変数に割り当てられている文字列を入れ替える。<br>
     * 変数に割り当てられている文字列が変数の場合のみ入れ替える。
     *
     * @param varToken 変数
     * @param token 変数に割り当てたい文字列
     */
    private void replaceBindings(String varToken, String token) {
        for (Map.Entry<String, String> entry : vars.entrySet()) {
            String key = entry.getKey(), value = vars.get(key);
            if (varToken.equals(value)) vars.put(key, token);
        }
    }

    /**
     * トークンが変数かどうか調べる
     * @param str1 トークン
     * @return トークンが変数なら真。そうでなければ偽。
     */
    private boolean var(String str1) {
        // 先頭が ? なら変数
        return str1.startsWith("?");
    }

    String tokens1[];
    String tokens2[];
    String sentences[];
    String fileName;
    ArrayList<String> buffer;
    ArrayList<String> result;
    HashMap<String, String> vars;
    HashSet<HashMap<String, String>> varsSet = new HashSet<HashMap<String, String>>();
}


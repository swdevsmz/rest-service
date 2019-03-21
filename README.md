# rest-service

リモートデバッグの方法  
https://blogenist.jp/2018/12/04/6786/  

ツールバーのRunからEdit Configurationsを選択します。

次に、左上の+マークをクリックしてRemoteを選択します。

すると、設定ダイアログが表示されるので、Nameに任意の名称を入れ、その他はデフォルトのままでOKボタンをクリックします。

次に起動する際のコマンドに--debug-jvmオプションを加えて起動してみてください。

gradlew bootrun --debug-jvm

すると、以下のようにListening状態になります。

これは、5005ポートでデバッグ先を探している状態になります。
このログが表示されたらIntelliJ側で先ほど作成したRemoteで起動してみましょう。

実行  
gradlew bootrun
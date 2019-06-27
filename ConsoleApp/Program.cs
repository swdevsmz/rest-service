using System;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            ////スレッドを作成
            //var thread = new Thread(HeavyFunc);
            ////非同期処理開始
            //thread.Start();
            //Console.WriteLine("ワン！");

            ////ここで非同期処理が終わるまで待機
            //thread.Join();
            ////非同期処理が終わってから実行
            //Console.WriteLine("スリー！");

            ////非同期処理開始
            //Task task = Task.Run(() => HeavyFunc());
            //Console.WriteLine("ワン！");

            ////ここで非同期処理が終わるまで待機
            //task.Wait();
            ////非同期処理が終わってから実行
            //Console.WriteLine("スリー！");

            //非同期処理開始
            Task<string> task = StartAsync();
            Console.WriteLine("ワン");

            //ここで非同期処理が終わるまで待機
            //task.Wait();
            //StartAsyncから帰ってきた返り値を使える
            Console.WriteLine(task.Result);
        }

        //メソッドを定義
        static async Task<string> StartAsync()
        {
            await Task.Run(() => HeavyFunc());
            Console.WriteLine("スリー");
            return "フォー";
        }

        static void HeavyFunc()
        {
            for (int i = 0; i < 100000; i++)
            {
                for (int p = 0; p < 10000; p++) { }
            }
            Console.WriteLine("ツー！");
        }
    }
}

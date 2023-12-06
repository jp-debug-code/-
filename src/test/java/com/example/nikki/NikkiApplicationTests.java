package com.example.nikki;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class NikkiApplicationTests {
	@Test
	void MainScreenShotTest(){
		try(Playwright playwright=Playwright.create()){//Playwrightのインスタンスを作成し、resourceを自動的にクローズするためのtry-with-resources 文
			Browser browser=playwright.chromium().launch();//Chromiumブラウザを起動する
			BrowserContext context=browser.newContext();//新しいコンテキスト（ブラウザの状態やセッションを保持するオブジェクト）を作成
			Page page=context.newPage();//新しいページをブラウザコンテキスト内に作成する
			page.navigate("http://localhost:8080/diary");//作成したページを指定したURLにナビゲート
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TestPhoto/main.png")));//ページのスクリーンショットを撮影し、指定したパスに保存
		}}//try-with-resources文→try(リソース初期化)リソースを使用するコード　catch(例外　変数){} finaly{必要に応じてクリーンアップ}
		@Test
		void ListScreenShotTest(){
			try(Playwright playwright=Playwright.create()){
				Browser browser=playwright.chromium().launch();
				BrowserContext context=browser.newContext();
				Page page=context.newPage();
				page.navigate("http://localhost:8080/diary/list");
				page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TestPhoto/list.png")));
			}
	}
	@Test
	void CreateScreenShotTest(){
		try(Playwright playwright=Playwright.create()){
			Browser browser=playwright.chromium().launch();
			BrowserContext context=browser.newContext();
			Page page=context.newPage();
			page.navigate("http://localhost:8080/diary/create");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("TestPhoto/create.jpg")));

		}

		}
	@Test
ls
	void MainVideoShotTest(){
		try(Playwright playwright=Playwright.create()){//Playwrightのインスタンスを作成し、resourceを自動的にクローズするためのtry-with-resources 文
			Browser browser=playwright.chromium().launch();//Chromiumブラウザを起動する
			BrowserContext newContext = browser.newContext(
					new Browser.NewContextOptions().setRecordVideoDir(Paths.get("Videos/")).setRecordVideoSize(1280, 720));
			Page page = newContext.newPage();
			page.navigate("http://localhost:8080/diary");
			Thread.sleep(30000);

			newContext.close();
			playwright.close();
		} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
	}






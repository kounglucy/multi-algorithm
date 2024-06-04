package step01.jsoup;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.domain.FootballNews;

public class JsoupTest {
	public static void main(String[] args) {
		// 문     서    : Document
		// 요소(들) : Element(s)
		
		Document doc;
		try {
			// step01 : 기본 
			/*
			 #mp-itn > ul > li:nth-child(1) > b > a
			 #mp-itn > ul > li:nth-child(2) > b > a
			 #mp-itn > ul > li:nth-child(3) > b > a
			 * 
			 * 
			 */
			/*
			doc = Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get();
//			System.out.println(doc.title());
//			System.out.println(doc.getElementsByTag("title").get(0).text());
//			System.out.println(doc.select(".mw-headline"));
			
			
			Elements inTheNews = doc.select("#mp-itn > ul > li > b > a");
//			System.out.println(inTheNews);
			for(Element news : inTheNews) {
				System.out.println(news.absUrl("href"));
			}
			*/
			
			
			// step02 : 공통 특징
			/*
			 * https://www.w3schools.com/java/default.asp
			 * 
			 * [예상결과]
				Examples in Each Chapter 	: #main > h2:nth-child(6)
				Java Exercises				: #main > h2:nth-child(12)
				Java Quiz					: #main > h2:nth-child(17)
				Learn by Examples			: #main > h2:nth-child(21)
				My Learning					: #main > h2:nth-child(26)
				Java Reference				: #main > h2:nth-child(33)
				Download Java				: #main > h2:nth-child(38)
			 * 
			 */
			
			/*
			doc = Jsoup.connect("https://www.w3schools.com/java/default.asp").get();
			
			// select : #main > h2:nth-child(6)
			// jsPath : document.querySelector("#main > h2:nth-child(6)")
			// styles : 
					// -webkit-text-size-adjust: 100%;
					// line-height: 1.5;
					// color: #000!important;
					// box-sizing: inherit;
					// font-family: "Segoe UI",Arial,sans-serif;
					// font-weight: 400;
					// margin: 10px 0;
					// font-size: 32px;
			// xPath : //*[@id="main"]/h2[1]
			// fullXPath : /html/body/div[7]/div[1]/div[1]/h2[1]
			
			Elements titles = doc.select("#main > h2");
//			for(int i = 0; i < titles.size() ; i++) {
//				System.out.println(titles.get(i).text());
//			}
			
//			for(Element title : titles) {
//				System.out.println(title);
//			}
			*/
			
			// step03 : 실생활
			/*
			 * https://sports.news.naver.com/wfootball/index.nhn
			 * 
			 * [예상결과]
				---------------------------------------------------------
				제목 : 추천뉴스
				---------------------------------------------------------
				하다하다 이제 강등권? 토트넘 감독 후보 추가요
				https://sports.news.naver.com/news?oid=076&aid=0003988901
				
				'튀르키예서 사라진 최고 재능→26살이지만 은퇴도 좋은 선택'
				https://sports.news.naver.com/news?oid=117&aid=0003713479
				
				'해버지의 위엄'...UCL 공식계정, 박지성 생일에 "빅게임 플레이어!" 극찬
				https://sports.news.naver.com/news?oid=411&aid=0000025890
				
				'마요르카 복귀' 이강인, "팬 관심 속에 다시 한번 축구 열정 느껴"
				https://sports.news.naver.com/news?oid=109&aid=0004818859
				
				히샬리송이 인정해버린 촌극...선수단-콘테 불화, 사실이었나
				https://sports.news.naver.com/news?oid=413&aid=0000157185
				
				'PL 379경기 뛴' 박지성 절친, 명예의 전당 후보에서 제외…왜?
				https://sports.news.naver.com/news?oid=311&aid=0001575436
				
				김민재, 2번째 세리에A 이달의 선수 무산…동료 크바라츠헬리아 수상
				https://sports.news.naver.com/news?oid=421&aid=0006719008
				
				'콘테 대행' 스텔리니 입 열었다 "내가 바로 적임자"
				https://sports.news.naver.com/news?oid=076&aid=0003988893
				
				2군도 못 제치는 1,400억 기적, ‘제발 우리팀에 와줘’ 또 러브콜
				https://sports.news.naver.com/news?oid=139&aid=0002181658
				
				'충격' 원하지 않았던 영입…홀란 '대기록' 작성하고도 매각된다
				https://sports.news.naver.com/news?oid=216&aid=0000126930
				
				유스팀 등번호로 강제 변경…'1조4000억→0원' 위기 [공식]
				https://sports.news.naver.com/news?oid=477&aid=0000419635
				
				첼시 DF "내 여동생? EPL 선수보다 축구 잘해"...팬들은 "너보단 낫겠지"
				https://sports.news.naver.com/news?oid=117&aid=0003713470
				
				'충격적 성 스캔들 터졌다'…아르헨 WC 우승 멤버, 성폭력 혐의
				https://sports.news.naver.com/news?oid=117&aid=0003713469
				
				‘챔피언’ 메시, 2026 월드컵 출전 결심
				https://sports.news.naver.com/news?oid=139&aid=0002181657
				
				나겔스만, 포터 대체자로 거론..."첼시 보드진과 첫 접촉"
				https://sports.news.naver.com/news?oid=411&aid=0000025888
				
				부상보다 더 큰 위기…오시멘, 아프리카서 '행운의 마스크' 분실
				https://sports.news.naver.com/news?oid=311&aid=0001575424
				
				'출전시간 부족' 정우영, 몸값 150만 유로 하락...이재성과 같다
				https://sports.news.naver.com/news?oid=413&aid=0000157183
				
				"난 아스널 우승 원하지만..." 루니,맨시티 '역전우승' 예언
				https://sports.news.naver.com/news?oid=076&aid=0003988882
				
				'동갑내기 친구' 루니, "호날두, 맨유 더럽히지 않았어"
				https://sports.news.naver.com/news?oid=109&aid=0004818806
				
				스코틀랜드 언론, 오현규 발언 집중 조명..."日 감독 비판 일축해"
				https://sports.news.naver.com/news?oid=311&aid=0001575415
				
				[FootballNews [title=하다하다 이제 강등권? 토트넘 감독 후보 추가요, url=https://sports.news.naver.com/news?oid=076&aid=0003988901], FootballNews [title='튀르키예서 사라진 최고 재능→26살이지만 은퇴도 좋은 선택', url=https://sports.news.naver.com/news?oid=117&aid=0003713479], FootballNews [title='해버지의 위엄'...UCL 공식계정, 박지성 생일에 "빅게임 플레이어!" 극찬, url=https://sports.news.naver.com/news?oid=411&aid=0000025890], FootballNews [title='마요르카 복귀' 이강인, "팬 관심 속에 다시 한번 축구 열정 느껴", url=https://sports.news.naver.com/news?oid=109&aid=0004818859], FootballNews [title=히샬리송이 인정해버린 촌극...선수단-콘테 불화, 사실이었나, url=https://sports.news.naver.com/news?oid=413&aid=0000157185], FootballNews [title='PL 379경기 뛴' 박지성 절친, 명예의 전당 후보에서 제외…왜?, url=https://sports.news.naver.com/news?oid=311&aid=0001575436], FootballNews [title=김민재, 2번째 세리에A 이달의 선수 무산…동료 크바라츠헬리아 수상, url=https://sports.news.naver.com/news?oid=421&aid=0006719008], FootballNews [title='콘테 대행' 스텔리니 입 열었다 "내가 바로 적임자", url=https://sports.news.naver.com/news?oid=076&aid=0003988893], FootballNews [title=2군도 못 제치는 1,400억 기적, ‘제발 우리팀에 와줘’ 또 러브콜, url=https://sports.news.naver.com/news?oid=139&aid=0002181658], FootballNews [title='충격' 원하지 않았던 영입…홀란 '대기록' 작성하고도 매각된다, url=https://sports.news.naver.com/news?oid=216&aid=0000126930], FootballNews [title=유스팀 등번호로 강제 변경…'1조4000억→0원' 위기 [공식], url=https://sports.news.naver.com/news?oid=477&aid=0000419635], FootballNews [title=첼시 DF "내 여동생? EPL 선수보다 축구 잘해"...팬들은 "너보단 낫겠지", url=https://sports.news.naver.com/news?oid=117&aid=0003713470], FootballNews [title='충격적 성 스캔들 터졌다'…아르헨 WC 우승 멤버, 성폭력 혐의, url=https://sports.news.naver.com/news?oid=117&aid=0003713469], FootballNews [title=‘챔피언’ 메시, 2026 월드컵 출전 결심, url=https://sports.news.naver.com/news?oid=139&aid=0002181657], FootballNews [title=나겔스만, 포터 대체자로 거론..."첼시 보드진과 첫 접촉", url=https://sports.news.naver.com/news?oid=411&aid=0000025888], FootballNews [title=부상보다 더 큰 위기…오시멘, 아프리카서 '행운의 마스크' 분실, url=https://sports.news.naver.com/news?oid=311&aid=0001575424], FootballNews [title='출전시간 부족' 정우영, 몸값 150만 유로 하락...이재성과 같다, url=https://sports.news.naver.com/news?oid=413&aid=0000157183], FootballNews [title="난 아스널 우승 원하지만..." 루니,맨시티 '역전우승' 예언, url=https://sports.news.naver.com/news?oid=076&aid=0003988882], FootballNews [title='동갑내기 친구' 루니, "호날두, 맨유 더럽히지 않았어", url=https://sports.news.naver.com/news?oid=109&aid=0004818806], FootballNews [title=스코틀랜드 언론, 오현규 발언 집중 조명..."日 감독 비판 일축해", url=https://sports.news.naver.com/news?oid=311&aid=0001575415]]
				-------
			*/
			doc = Jsoup.connect("https://sports.news.naver.com/wfootball/index.nhn").get();
			Elements homeNews = doc.select(".home_news");
			System.out.println("---------------------------------------------------");
			System.out.println("제목 : " + homeNews.get(0).text().substring(0, 4));
			System.out.println("---------------------------------------------------");
			
			ArrayList<FootballNews> news = new ArrayList<FootballNews>();
			
			for(Element newsList : homeNews.select("li")) {
				String newsTitle = newsList.text();
				String newsUrl = newsList.getElementsByTag("a").get(0).absUrl("href");
				
				System.out.println(newsTitle);
				System.out.println(newsUrl);
				System.out.println();
				
				news.add(new FootballNews(newsTitle, newsUrl));
			}
			
			System.out.println(news);
			System.out.println("---------------------------------------------------");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}











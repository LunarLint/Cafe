package Cafe_test2;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// 변수들
		Register register = new Register();
		Manage manage = new Manage();
		CafeIO cafeIO = new CafeIO();

		// 파일 생성 테스트
		cafeIO.readFile();
		cafeIO.readReader();

		// 전체 내용 출력하기
		for (CafeDTO cafedto : ArrayMemberList.memberList) {
			System.out.println(cafedto.toString());
		}

		// 회원가입 테스트
		System.out.println("회원가입 테스트");
		register.regist();

		// 데이터, 배열 저장 테스트
		System.out.println("데이터, 베열 저장 정상 작동 테스트");
		cafeIO.readReader();

		// 전체 내용 출력하기
		for (CafeDTO cafedto : ArrayMemberList.memberList) {
			System.out.println(cafedto.toString());
		}

		// 로그인 테스트
		System.out.println("로그인 테스트");
		manage.login();

		// 조회 테스트
		// manage.Search();

		// 삭제 테스트
		// System.out.println("삭제 테스트");
		// manage.Delete();

		// 파일 정상작동 확인
		// cafeIO.readReader();

		// 변경 테스트
		// System.out.println("변경 테스트");
		// manage.Update();

		// 데이터, 배열 저장 테스트
		// System.out.println("데이터, 베열 저장 정상 작동 테스트");
		// cafeIO.readReader();

		// 전체 내용 출력하기
		// for (CafeDTO cafedto : ArrayMemberList.memberList) {
		// System.out.println(cafedto.toString());
		// }
		// System.out.println("배열 수 : " + ArrayMemberList.memberList.size());
	}

}

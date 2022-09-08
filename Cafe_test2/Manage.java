package Cafe_test2;

import java.util.Scanner;

public class Manage extends CafeIO {
	Scanner sc = new Scanner(System.in);
	int ididx = 0;
	int gradeidx;
	CafeDTO cafedto = new CafeDTO();

	// 로그인
	public int login() {
		String loginId = "";
		String loginPw = "";

		// 일치 시 - true / 불일치 시 - false
		boolean id_pass = false;
		boolean pw_pass = false;

		// 배열 작동 확인
		try {
			System.out.println(ArrayMemberList.memberList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		do {
			System.out.print("아이디 : ");
			loginId = sc.nextLine();
			if (loginId.equals("-1")) {
				// 여기에 메인화면으로 나가는 코드를 입력.
			} else {
				for (int i = 0; i < ArrayMemberList.memberList.size(); i++) {
					// System.out.println("for 진입");
					if (loginId.equals(ArrayMemberList.memberList.get(i).getId())) {
						id_pass = true;
						System.out.println("아이디 성공");
						ididx = i;
						break;
					}
				}
				if (id_pass == false) {
					System.out.println("없는 아이디 입니다.");
				}
			}
		} while (id_pass == false);

		do {
			System.out.print("비밀번호 : ");
			loginPw = sc.nextLine();
			for (int i = 0; i < ArrayMemberList.memberList.size(); i++) {
				if (loginPw.equals(ArrayMemberList.memberList.get(i).getPassword()) && (i == ididx)) {
					pw_pass = true;
					gradeidx = Integer.parseInt(ArrayMemberList.memberList.get(i).getGrade());
					break;
				}
			}
			if (pw_pass == false) {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} while (pw_pass == false);

		System.out.println("로그인 성공");
		return gradeidx;
	}

	// 조회
	public void Search() {
		// 개인조회
		String search_name = "";
		boolean search_pass = false;

		System.out.println("검색할 이름 : ");
		search_name = sc.nextLine();

		for (int i = 0; i < ArrayMemberList.memberList.size(); i++) {
			if (search_name.equals(ArrayMemberList.memberList.get(i).getName())) {
				System.out.println(search_name + "님");
				System.out.println("나이 : " + ArrayMemberList.memberList.get(i).getBirthday());
				System.out.println("등급 : " + ArrayMemberList.memberList.get(i).getGrade());
				search_pass = true;
			}
		}
		if (search_pass == false) {
			System.out.println("없는 이름 입니다");
		}
	}

	// 삭제
	public void Delete() {
		String deletePw = "";

		System.out.print("비밀번호를 입력하세요 : ");
		deletePw = sc.nextLine();

		if (deletePw.equals(ArrayMemberList.memberList.get(ididx).getPassword())) {
			ArrayMemberList.memberList.remove(ididx);

			// 덮어쓰기
			overwriteFile();

			System.out.println("탈퇴 완료");
		}

		else {
			System.out.println("비밀번호가 틀렸습니다");
		}
	}

	// 변경
	public void Update() {
		int choice;
		String update_name, update_password;
		String update_grade;

		// 이름,비밀번호,등급 변경
		do {
			System.out.print("변경할 정보 선택[0 - 이름 / 1 - 비밀번호 / 2 - 등급] : ");
			choice = sc.nextInt();
			sc.nextLine();
			if (choice < 0 || choice > 3) {
				System.out.println("다시 입력해주세요");
			}
		} while (choice < 0 || choice > 3);

		switch (choice) {
		// 이름
		case 0:
			System.out.print("변경할 이름 : ");
			update_name = sc.nextLine();

			cafedto.setName(update_name);
			cafedto.setBirthday(memberList.get(ididx).getBirthday());
			cafedto.setFd(memberList.get(ididx).getFd());
			cafedto.setId(memberList.get(ididx).getId());
			cafedto.setPassword(memberList.get(ididx).getPassword());
			cafedto.setGrade(memberList.get(ididx).getGrade());
			cafedto.setPoint(memberList.get(ididx).getPoint());

			memberList.set(ididx, cafedto);

			// 덮어쓰기
			overwriteFile();
			break;

		// 비밀번호
		case 1:
			System.out.print("변경할 비밀번호 : ");
			update_password = sc.nextLine();

			cafedto.setPassword(update_password);
			cafedto.setBirthday(memberList.get(ididx).getBirthday());
			cafedto.setFd(memberList.get(ididx).getFd());
			cafedto.setId(memberList.get(ididx).getId());
			cafedto.setName(memberList.get(ididx).getName());
			cafedto.setGrade(memberList.get(ididx).getGrade());
			cafedto.setPoint(memberList.get(ididx).getPoint());

			memberList.set(ididx, cafedto);

			// 덮어쓰기
			overwriteFile();
			break;

		// 등급
		case 2:
			do {
				System.out.print("변경할 등급 : ");
				update_grade = sc.nextLine();
			} while (!update_grade.equals("0") || !update_grade.equals("1") || !update_grade.equals("2"));
			cafedto.setGrade(update_grade);
			cafedto.setBirthday(memberList.get(ididx).getBirthday());
			cafedto.setFd(memberList.get(ididx).getFd());
			cafedto.setId(memberList.get(ididx).getId());
			cafedto.setPassword(memberList.get(ididx).getPassword());
			cafedto.setName(memberList.get(ididx).getName());
			cafedto.setPoint(memberList.get(ididx).getPoint());

			memberList.set(ididx, cafedto);

			// 덮어쓰기
			overwriteFile();
		}

	}
}

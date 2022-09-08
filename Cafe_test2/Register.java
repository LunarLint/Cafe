package Cafe_test2;

import java.io.IOException;
import java.util.Scanner;

public class Register extends CafeIO {

	Scanner sc = new Scanner(System.in);
	final String only_number = "[0-9]+";

	public void regist() throws IOException {
		CafeDTO cafeDTO = new CafeDTO();

		String uid;
		boolean tf = true;

		do {
			System.out.print("사용할 아이디 : ");
			uid = sc.nextLine();
			for (int i = 0; i < ArrayMemberList.memberList.size(); i++) {
				if (uid.equals(ArrayMemberList.memberList.get(i).getId())) {
					tf = false;
					System.out.println("중복된 아이디 입니다.");
					break;
				} else {
					tf = true;
				}

			}
		} while (tf == false);
		if (tf == true) {
			cafeDTO.setId(uid);
		}

		System.out.print("사용할 비밀번호 : ");
		cafeDTO.setPassword(sc.nextLine());

		System.out.print("이름 : ");
		cafeDTO.setName(sc.nextLine());

		String resist_birthday;
		while (true) {
			System.out.print("생년월일(6글자) : ");
			resist_birthday = sc.nextLine();

			if (resist_birthday.matches(only_number) && resist_birthday.length() == 6) {
				break;
			} else {
				System.out.println("올바르게 입력해주세요");
			}
		}
		cafeDTO.setBirthday(resist_birthday);

		// 회원가입 시 포인트 = 0
		cafeDTO.setPoint(0);

		// 회원가입 시 등급 (2 = 일반)
		cafeDTO.setGrade("2");

		// 성공적인 회원가입 시
		System.out.println("\n회원가입 완료\n");

		// 임시 데이터 추가
		getMemberList().add(cafeDTO);

		// 파일에 데이터 추가
		overwriteFile();

	}
}

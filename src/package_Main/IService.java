package package_Main;

import java.util.Map;

import package_VO.UserVO;

public interface IService {
	/**
	 * 
	 * 회원가입 - 유저 정보 DB에 입력
	 * 
	 * @param userVO
	 * @return 성공 시 true, 실패 시 false 반환
	 * @author
	 */
	boolean insertUser(UserVO userVO);
	
	/**
	 * 
	 * id 중복 여부와 조건을 만족하는지 확인
	 * 
	 * @param id
	 * @return 만족하면 true, 불만족하면 false 반환
	 * @author
	 * 
	 */
	boolean checkId(String id);
	
	/**
	 * 
	 * 관리자 계정 로그인
	 * 
	 * @param loginInfo
	 * @return 로그인 성공 시 true, 실패 시 true 반환
	 * @author
	 */
	boolean adminLogin(Map<String, String> loginInfo);
	
	/**
	 * 회원 계정 로그인
	 * 
	 * @param loginInfo
	 * 	<"user_id","user_id">,<"user_pw","user_pw"> 키/값을 전송하여 로그인
	 * 성공여부 반환받음
	 * @return 로그인 성공 시 true, 실패 시 false 반환
	 * @author
	 */
	boolean userLogin(Map<String, String> loginInfo);
	
	
	
	
	
	
	
	
	
}

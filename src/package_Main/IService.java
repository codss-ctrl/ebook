package package_Main;

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
	 * 
	 */
	boolean checkId(String id);
	
	/**
	 * 
	 * 관리자 계정 로그인
	 * 
	 * @param loginInfo
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

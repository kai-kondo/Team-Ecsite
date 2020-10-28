package jp.co.internous.cepheus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.cepheus.model.domain.TblCart;
import jp.co.internous.cepheus.model.domain.dto.CartDto;
import jp.co.internous.cepheus.model.form.CartForm;
import jp.co.internous.cepheus.model.mapper.TblCartMapper;
import jp.co.internous.cepheus.model.session.LoginSession;

@Controller
@RequestMapping("/cepheus/cart")
public class CartController {
	@Autowired
	private TblCartMapper cartMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	private Gson gson = new Gson();
	
	@RequestMapping("/")
	public String index(Model m) {
		//LogginSessionからuserIdを取得　//
		int userId = loginSession.getLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
		// カート情報を取得する　//
		List<CartDto> carts =cartMapper.findByUserId(userId);
			m.addAttribute("loginSession", loginSession);
			m.addAttribute("carts", carts);
		return "cart";
	}
	
@RequestMapping( "/add")
public String addCart(CartForm f, Model m) {
	//LoginSessionからuserIdを取得
	int userId = loginSession.getLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();
	
	f.setUserId(userId);
	/*ユーザーに紐づくカート情報に追加する商品が一致したら、
	 * 個数を足して更新処理、存在しない場合はカート登録する
	 */
	TblCart cart = new TblCart(f);
	int result = 0;
	if (cartMapper.findCountByUserIdAndProuductId(userId, f.getProductId()) > 0) {
			result = cartMapper.update(cart);
	} else {
			result = cartMapper.insert(cart);
	}
	if (result > 0) {
		List<CartDto> carts = cartMapper.findByUserId(userId);
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("carts",carts);
	}		
	return "cart";
}

	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteCart(@RequestBody String checkedIdList) {
		int result = 0;
		
		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList");
		for (String id : checkedIds) {
			result += cartMapper.deleteById(Integer.parseInt(id));
		}
		return result > 0;
	}
}

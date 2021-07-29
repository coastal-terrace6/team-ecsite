package jp.co.internous.rainbow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.rainbow.model.domain.TblCart;
import jp.co.internous.rainbow.model.domain.dto.CartDto;
import jp.co.internous.rainbow.model.form.CartForm;
import jp.co.internous.rainbow.model.mapper.TblCartMapper;
import jp.co.internous.rainbow.model.session.LoginSession;

@Controller
@RequestMapping("/rainbow/cart")
public class CartController {
	/*
	 * MapperとloginSessionをここで定義
	 * アノテーションに@Aoutowiredを設定
	 */
	@Autowired
	private TblCartMapper cartMapper;

	@Autowired
	private LoginSession loginSession;

	private Gson gson = new Gson();

	/**
	 * Cart.htmlを表示する関数
	 * @param m 画面に渡すデータ
	 * @return "cart"に遷移
	 */
	@RequestMapping("/")
	public String index(Model m) {
		/*
		 * ユーザーID習得
		 */
		int userId = loginSession.getLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();

		/*
		 * カート情報習得
		 */
		List<CartDto> carts = cartMapper.findByUserId(userId);

		m.addAttribute("loginSession", loginSession);
		m.addAttribute("carts", carts);
		return "cart";
	}

	/**
	 * "/add"を受けとった時に
	 * カートへの商品追加を実行するメソッド
	 * ユーザーID、商品IDを受け取って処理を行う
	 * @param f カートフォーム
	 * @param m 画面に渡すデータ
	 * @return "cart"に遷移
	 */
	@RequestMapping("/add")
	public String addCart(CartForm f, Model m) {
		/*
		 * ユーザーID習得
		 */
		int userId = loginSession.getLogined() ? loginSession.getUserId() : loginSession.getTmpUserId();

		f.setUserId(userId);
		/*
		 * カートテーブルに挿入、更新
		 */
		TblCart cart = new TblCart(f);
		int result = 0;
		if(cartMapper.findCountByUserIdAndProuductId(userId, f.getProductId()) > 0) {
			result = cartMapper.update(cart);
		}else {
			result = cartMapper.insert(cart);
		}
		if(result > 0) {
			List<CartDto> carts = cartMapper.findByUserId(userId);
			m.addAttribute("loginSession", loginSession);
			m.addAttribute("carts", carts);
		}
		/*
		 * 追加処理を終えた後はカート画面へ返す
		 */
		return "cart";
	}

	/**
	 * "/delete"を受けとった時に
	 * カートからの商品消去を実行する関数
	 * @param checkedIdList 画面でチェックされたチェックボックスのID
	 * @return チェックされたIDの有無を返却
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteCart(@RequestBody String checkedIdList) {
		int result = 0;

		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList");
		result = cartMapper.deleteById(checkedIds);
		return result > 0;
	}
}
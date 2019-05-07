package com.niit.CosmeticsFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CosmeticsBackend.Dao.CardDao;
import com.niit.CosmeticsBackend.Model.Card;


    @Controller
	public class CardController  {
		@Autowired 
		Card card;
		@Autowired 
		CardDao cardDao;
		
		@RequestMapping("/addcard")
		public ModelAndView addproduct()
		{
			List<Card> cards = cardDao.list();
		ModelAndView obj=new ModelAndView("addcard");
		obj.addObject("addcard", new Card());
		obj.addObject("cards", cards);
		return obj;
		}
		
		@RequestMapping	(value="/addcard_Processing", method=RequestMethod.POST)
		public ModelAndView cardProcessing(@ModelAttribute("addcard")Card card)
		{
			ModelAndView obj = new ModelAndView("redirect:/addcard");
			if(cardDao.saveorupdate(card))
			{
				obj.addObject("msg", "Successfully save card");
			}
			else
			{
				obj.addObject("msg", "Could not save card");
			}
			return obj;
		}
		
//		@RequestMapping("/edit_Card/{Card_id}")
//		public ModelAndView editcard(@PathVariable("Card_id")String Card_id)
//		{
//			List<Card> cards=cardDao.list();
//			ModelAndView obj=new ModelAndView("addcard");
//			card=cardDao.get(card_Id);
//			obj.addObject("cards",cards);
//			obj.addObject("addcard",card);
//			return obj;
//		}
//		@RequestMapping("/delete_Card/{Card_id}")
//		public ModelAndView deletecard(@PathVariable("Card_id")String Card_id)
//		{
//			ModelAndView obj=new ModelAndView("redirect:/addcard");
//			card=cardDao.get(card_Id);
//			if(cardDao.delete(card))
//			{
//				obj.addObject("msg","Card is deleted successfully");
//			}
//			else
//			{
//				obj.addObject("msg","Card cannot be deleted");
//			}
//			return obj;
//		}
	}

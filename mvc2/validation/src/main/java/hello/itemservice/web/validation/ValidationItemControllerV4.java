package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import hello.itemservice.domain.item.SaveCheck;
import hello.itemservice.domain.item.UpdateCheck;
import hello.itemservice.web.validation.form.ItemSaveForm;
import hello.itemservice.web.validation.form.ItemUpdateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/validation/v4/items")
@RequiredArgsConstructor
@Slf4j
public class ValidationItemControllerV4 {

    private final ItemRepository itemRepository;


    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "validation/v4/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v4/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "validation/v4/addForm";
    }


    //    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (item.getPrice() != null && item.getQuantity() != null) {
            int totalPrice = item.getPrice() * item.getQuantity();
            if (totalPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{"10000", totalPrice}, null);
            }
        }
        if (bindingResult.hasErrors()) {
            log.error("errors={}", bindingResult);
            // ModelAttribute에 담지 않아도 함께 담겨서 나가게 됨.
            return "validation/v4/addForm"; // 다시 입력 폼으로
        }

        // 검증 성공
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v4/items/{itemId}";
    }

    //    @PostMapping("/add")
    public String addItemV2(@Validated(SaveCheck.class) @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (item.getPrice() != null && item.getQuantity() != null) {
            int totalPrice = item.getPrice() * item.getQuantity();
            if (totalPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{"10000", totalPrice}, null);
            }
        }
        if (bindingResult.hasErrors()) {
            log.error("errors={}", bindingResult);
            // ModelAttribute에 담지 않아도 함께 담겨서 나가게 됨.
            return "validation/v4/addForm"; // 다시 입력 폼으로
        }

        // 검증 성공
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v4/items/{itemId}";
    }

    @PostMapping("/add")
    public String addItemV3(@Validated @ModelAttribute("item") ItemSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (form.getPrice() != null && form.getQuantity() != null) {
            int totalPrice = form.getPrice() * form.getQuantity();
            if (totalPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{"10000", totalPrice}, null);
            }
        }
        if (bindingResult.hasErrors()) {
            log.error("errors={}", bindingResult);
            // ModelAttribute에 담지 않아도 함께 담겨서 나가게 됨.
            return "validation/v4/addForm"; // 다시 입력 폼으로
        }
        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setQuantity(form.getQuantity());
        item.setPrice(form.getPrice());
        // 검증 성공
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/validation/v4/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "validation/v4/editForm";
    }

    //    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @Validated @ModelAttribute Item item, BindingResult bindingResult, Model model) {
        if (item.getPrice() != null && item.getQuantity() != null) {
            int totalPrice = item.getPrice() * item.getQuantity();
            if (totalPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{"10000", totalPrice}, null);
            }
        }
        if (bindingResult.hasErrors()) {
            log.error("errors={}", bindingResult);
            // ModelAttribute에 담지 않아도 함께 담겨서 나가게 됨.
            return "validation/v4/editForm"; // 다시 입력 폼으로
        }
        itemRepository.update(itemId, item);
        return "redirect:/validation/v4/items/{itemId}";
    }

    //    @PostMapping("/{itemId}/edit")
    public String editV2(@PathVariable Long itemId, @Validated(value = {UpdateCheck.class}) @ModelAttribute Item item, BindingResult bindingResult, Model model) {
        if (item.getPrice() != null && item.getQuantity() != null) {
            int totalPrice = item.getPrice() * item.getQuantity();
            if (totalPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{"10000", totalPrice}, null);
            }
        }
        if (bindingResult.hasErrors()) {
            log.error("errors={}", bindingResult);
            // ModelAttribute에 담지 않아도 함께 담겨서 나가게 됨.
            return "validation/v4/editForm"; // 다시 입력 폼으로
        }
        itemRepository.update(itemId, item);
        return "redirect:/validation/v4/items/{itemId}";
    }

    @PostMapping("/{itemId}/edit")
    public String editV3(@PathVariable Long itemId, @Validated @ModelAttribute("item") ItemUpdateForm form, BindingResult bindingResult, Model model) {
        if (form.getPrice() != null && form.getQuantity() != null) {
            int totalPrice = form.getPrice() * form.getQuantity();
            if (totalPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{"10000", totalPrice}, null);
            }
        }
        if (bindingResult.hasErrors()) {
            log.error("errors={}", bindingResult);
            // ModelAttribute에 담지 않아도 함께 담겨서 나가게 됨.
            return "validation/v4/editForm"; // 다시 입력 폼으로
        }
        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setQuantity(form.getQuantity());
        item.setPrice(form.getPrice());
        itemRepository.update(itemId, item);
        return "redirect:/validation/v4/items/{itemId}";
    }
}


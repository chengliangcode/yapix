package com.github.jetplugins.yapix.parse.util;

import com.github.jetplugins.yapix.model.DocTags;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaDocumentedElement;
import com.intellij.psi.javadoc.PsiDocComment;
import com.intellij.psi.javadoc.PsiDocTag;
import com.intellij.psi.javadoc.PsiDocToken;
import com.intellij.psi.javadoc.PsiInlineDocTag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * PsiDocComment相关工具类
 */
public class PsiDocCommentUtils {

    private PsiDocCommentUtils() {
    }


    /**
     * 获取获取标记自定字段名
     *
     * @param element sdfdsf
     */
    public static Map<String, String> getTagParamTextMap(PsiJavaDocumentedElement element) {
        Map<String, String> map = new HashMap<>();
        PsiDocTag[] tags = findTagsByName(element, DocTags.Param);
        for (PsiDocTag tag : tags) {
            PsiElement[] elements = tag.getDataElements();
            if (elements.length >= 2) {
                String name = elements[0].getText().trim();
                String description = elements[1].getText().trim();
                map.put(name, description);
            }
        }
        return map;
    }

    /**
     * 获取文档标记内容
     */
    public static String getDocCommentTagText(PsiJavaDocumentedElement element, String tagName) {
        String text = null;
        PsiDocComment comment = element.getDocComment();
        if (comment != null) {
            PsiDocTag tag = comment.findTagByName(tagName);
            if (tag != null && tag.getValueElement() != null) {
                text = tag.getValueElement().getText().trim();
            }
        }
        return text;
    }

    /**
     * 获取文档标题行
     */
    public static String getDocCommentTitle(PsiJavaDocumentedElement element) {
        PsiDocComment comment = element.getDocComment();
        if (comment != null) {
            return Arrays.stream(comment.getDescriptionElements())
                    .filter(o -> o instanceof PsiDocToken)
                    .map(PsiElement::getText)
                    .findFirst()
                    .map(String::trim)
                    .orElse(null);
        }
        return null;
    }

    /**
     * 获取文档注释上的标记
     */
    public static PsiDocTag findTagByName(PsiJavaDocumentedElement element, String tagName) {
        PsiDocComment comment = element.getDocComment();
        if (comment != null) {
            return comment.findTagByName(tagName);
        }
        return null;
    }


    /**
     * 获取文档注释上的标记
     */
    public static PsiDocTag[] findTagsByName(PsiJavaDocumentedElement element, String tagName) {
        PsiDocComment comment = element.getDocComment();
        if (comment != null) {
            return comment.findTagsByName(tagName);
        }
        return new PsiDocTag[0];
    }

    /**
     * 获取注释中link标记的内容
     */
    public static String getInlineLinkContent(PsiJavaDocumentedElement element) {
        PsiDocComment comment = element.getDocComment();
        if (comment == null) {
            return null;
        }
        PsiElement linkElement = Arrays.stream(comment.getDescriptionElements())
                .filter(ele -> (ele instanceof PsiInlineDocTag) && ele.getText().startsWith("{@link"))
                .findFirst().orElse(null);
        if (linkElement == null) {
            return null;
        }
        String text = linkElement.getText();
        return text.substring("{@link".length(), text.length() - 1).trim();
    }
}
package com.stkj.pperty.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @author HUANGP
 * @date 2018年2月27日
 * @des 泛型树创建
 * @param <T>
 *            自定义节点属性字段实体
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class TreeBuilder<T extends BaseNode> {

	public List<T> buildListToTree(List<T> dirs) {
		List<T> roots = findRoots(dirs);
		List<T> notRoots = (List<T>) CollectionUtils.subtract(dirs, roots);
		for (T root : roots) {
			root.setChild(findChildren(root, notRoots));
		}
		return roots;
	}

	private List<T> findRoots(List<T> allNodes) {
		List<T> results = new ArrayList<T>();
		for (T node : allNodes) {
			boolean isRoot = true;
			for (T comparedOne : allNodes) {
				if (node.getParentId() == comparedOne.getId()) {
					isRoot = false;
					break;
				}
			}
			if (isRoot) {
				node.setLevel(0);
				results.add(node);
				node.setRootId(node.getId());
			}
		}
		return results;
	}

	private List<T> findChildren(T root, List<T> allNodes) {
		List<T> children = new ArrayList<T>();

		for (T comparedOne : allNodes) {
			if (comparedOne.getParentId() == root.getId()) {
				comparedOne.setParent(root);
				comparedOne.setLevel(root.getLevel() + 1);
				children.add(comparedOne);
			}
		}
		List<T> notChildren = (List<T>) CollectionUtils.subtract(allNodes, children);
		for (T child : children) {
			List<T> tmpChildren = findChildren(child, notChildren);
			if (tmpChildren == null || tmpChildren.size() < 1) {
				child.setLeaf(true);
			} else {
				child.setLeaf(false);
			}
			child.setChild(tmpChildren);
		}
		return children;
	}

	public static void main(String[] args) {
		List<Node> allNodes = new ArrayList<Node>();
		allNodes.add(new Node(2, 1, "1栋", "010100"));
		allNodes.add(new Node(3, 1, "2栋", "010200"));
		allNodes.add(new Node(4, 2, "1号房", "010101"));
		allNodes.add(new Node(5, 2, "1号房", "010102"));
		allNodes.add(new Node(1, 0, "1单元", "010000"));
		allNodes.add(new Node(6, 3, "1号房", "010201"));
		List<Node> roots = new TreeBuilder<Node>().buildListToTree(allNodes);
		System.out.println(roots.get(0));
	}
}
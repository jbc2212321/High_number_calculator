# coding=utf-8
from sympy.parsing.latex import parse_latex, LaTeXParsingError
from sympy import diff, latex,Symbol,E,series,integrate


def high_diff(latex_line, symbol_num="x", order=1):
    """

    :param latex_line: latex
    :param symbol_num: string
    :param order: int
    :return: string
    """
    try:
        x = Symbol(symbol_num)
        line = latex_line
        return latex(diff(parse_latex(line).subs({"e": E}), x, order))
    except LaTeXParsingError:
        return "数据异常!"

def high_tylor(latex_line, x0=0, order=6):
    """

    :param latex_line: latex
    :param x0: int
    :param order:int
    :return:
    """
    try:
        function = parse_latex(latex_line).subs({"e": E})
        return latex(series(function, x0=x0, n=order))
    except LaTeXParsingError:
        return "数据异常!"

def high_one_integral(latex_line, symbol, lower_bound, upper_bound):
    """

    :param latex_line: latex
    :param symbol: symbol
    :param lower_bound: float/latex
    :param upper_bound: float/latex
    :return:
    """
    try:
        latex_line = parse_latex(latex_line).subs({"e": E})
        symbol = Symbol(symbol)
        upper_bound = parse_latex(str(upper_bound)).subs({"e": E})
        lower_bound = parse_latex(str(lower_bound)).subs({"e": E})
        return latex(integrate(latex_line, (symbol, lower_bound, upper_bound)))
    except LaTeXParsingError:
        return "数据异常!"


def high_two_integral(latex_line, symbol_1, lower_bound_1, upper_bound_1, symbol_2, lower_bound_2, upper_bound_2):
    """

    :param latex_line: latex
    :param symbol_1: symbol
    :param lower_bound_1: float/latex
    :param upper_bound_1: float/latex
    :param symbol_2: symbol
    :param lower_bound_2: float/latex
    :param upper_bound_2: float/latex
    :return: latex
    """
    try:
        latex_line = parse_latex(latex_line).subs({"e": E})
        symbol_1 = Symbol(symbol_1)
        symbol_2 = Symbol(symbol_2)
        upper_bound_1 = parse_latex(str(upper_bound_1)).subs({"e": E})
        lower_bound_1 = parse_latex(str(lower_bound_1)).subs({"e": E})
        upper_bound_2 = parse_latex(str(upper_bound_2)).subs({"e": E})
        lower_bound_2 = parse_latex(str(lower_bound_2)).subs({"e": E})
        tuple1 = (symbol_1, lower_bound_1, upper_bound_1)
        tuple2 = (symbol_2, lower_bound_2, upper_bound_2)
        return latex(integrate(latex_line, tuple1, tuple2))
    except LaTeXParsingError:
        return "数据异常!"
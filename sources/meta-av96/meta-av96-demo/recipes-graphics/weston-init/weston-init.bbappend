FILESEXTRAPATHS_prepend_stm32mp1-av96-common := "${THISDIR}/${PN}:"

do_install_append_stm32mp1-av96-common() {

	if ${@bb.utils.contains('GLIBC_GENERATE_LOCALES','fr_FR.UTF-8','true','false',d)}; then
		sed 's/keymap_layout=us/keymap_layout=fr/g' -i ${WORKDIR}/etc/xdg/weston/weston.ini
	fi
}

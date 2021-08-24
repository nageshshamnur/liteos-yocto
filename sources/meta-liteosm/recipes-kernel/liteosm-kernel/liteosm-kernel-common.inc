# Common settings for all liteosm recipes

LITEOSM_INHERIT_CLASSES += "python3native deploy logging"
inherit ${LITEOSM_INHERIT_CLASSES}

#inherit python3native
#inherit deploy
#inherit logging

# There shouldn't be a manifest for liteosm kernels since there is no root
# filesystem.
IMAGE_NO_MANIFEST = "1"

DEPENDS += "gperf-native python3-pyelftools-native python3-pyyaml-native python3-pykwalify-native"

DEPENDS_append_qemuall = " qemu-native qemu-helper-native"

#IMAGE_FSTYPES = "elf bin"

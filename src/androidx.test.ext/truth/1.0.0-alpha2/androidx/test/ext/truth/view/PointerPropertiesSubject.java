package androidx.test.ext.truth.view;

import android.support.annotation.Nullable;
import android.view.MotionEvent.PointerProperties;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.google.common.truth.Truth;

/** {@link Subject} for {@link PointerProperties} */
public final class PointerPropertiesSubject
    extends Subject<PointerPropertiesSubject, PointerProperties> {

  public static PointerPropertiesSubject assertThat(PointerProperties other) {
    return Truth.assertAbout(pointerProperties()).that(other);
  }

  public static Subject.Factory<PointerPropertiesSubject, PointerProperties> pointerProperties() {
    return PointerPropertiesSubject::new;
  }

  private PointerPropertiesSubject(
      FailureMetadata failureMetadata, @Nullable PointerProperties pointerProperties) {
    super(failureMetadata, pointerProperties);
  }

  public void hasId(int id) {
    check("id").that(actual().id).isEqualTo(id);
  }

  public void hasToolType(int toolType) {
    check("toolType").that(actual().toolType).isEqualTo(toolType);
  }

  public void isEqualTo(PointerProperties other) {
    check("id").that(actual().id).isEqualTo(other.id);
    check("toolType").that(actual().toolType).isEqualTo(other.toolType);
  }
}
